package com.ducdm.nmvvm.agents;

import android.content.Context;
import android.content.Intent;

import com.ducdm.nmvvm.agents.bundlizers.INMvxNavigationSerializer;
import com.ducdm.nmvvm.agents.finders.NMvxViewLookupper;
import com.ducdm.nmvvm.agents.models.INMvxBundle;
import com.ducdm.nmvvm.commons.Constants;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.viewmodels.INMvxViewModel;
import com.ducdm.nmvvm.views.NMvxView;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public class NMvxViewsPopulator extends NMvxViewLookupper implements INMvxViewsPopulator {

    private Context context;

    public NMvxViewsPopulator(Context context){
        super();
        this.context = context;
    }

    @Override
    public Intent getIntent(NMvxViewModelWrapper viewModelWrapper) {
        return getIntentByRequest(viewModelWrapper);
    }

    @Override
    public INMvxViewModel lookupViewModel(Intent intent, INMvxBundle bundle) {
        return null;
    }

    private Intent getIntentByRequest(NMvxViewModelWrapper viewModelWrapper){
        try{
            Class<? extends NMvxView> viewType = lookupViewType(viewModelWrapper.getViewModelType());

            String parameters = NMvx.resolve(INMvxNavigationSerializer.class).getSerializer().writeData(viewModelWrapper);

            if(parameters == null){
                return null;
            }

            Intent intent = new Intent(context, viewType);
            intent.putExtra(Constants.NAVIGATION_KEY, parameters);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            return intent;
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }
    }

}
