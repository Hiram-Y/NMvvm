package com.ducdm.nmvvm.agents.finders;

import com.annimon.stream.Stream;
import com.ducdm.nmvvm.dynamicscanner.INMvxDynamicScanner;
import com.ducdm.nmvvm.mappings.NMvx;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;
import com.ducdm.nmvvm.views.NMvxView;

import java.lang.reflect.Modifier;
import java.util.HashMap;

import static com.annimon.stream.Collectors.toList;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public class NMvxDynamicViewModelViewLoader implements INMvxDynamicViewModelViewLoader {

    private INMvxDynamicScanner dynamicScanner;
    private LoaderQuery results;
    private HashMap<Class<? extends NMvxViewModel>, Class<? extends NMvxView>> mappedResults = new HashMap<Class<? extends NMvxViewModel>, Class<? extends NMvxView>>();

    public NMvxDynamicViewModelViewLoader(String packageName){
        dynamicScanner = NMvx.resolve(INMvxDynamicScanner.class);
        prepareLoader(packageName);
    }

    private void prepareLoader(String packageName){
        results = new LoaderQuery(Stream.of(dynamicScanner.scan(packageName))
                .filter(x -> Modifier.isPublic(x.getModifiers())
                        && !Modifier.isStatic(x.getModifiers())
                        && !Modifier.isAbstract(x.getModifiers())
                        && !Modifier.isInterface(x.getModifiers()))
                .collect(toList()));
    }

    @Override
    public void startMapping() {
        Stream.of(results)
                .filter(x -> x.getSimpleName().endsWith("View")
                        && NMvxView.class.isAssignableFrom(x))
                .forEach(x -> {
                    Class<? extends NMvxViewModel> correspondingViewModel = (Class<? extends NMvxViewModel>) this.findCorrespondingViewModel(x.getSimpleName().substring(0, x.getSimpleName().length() - 4));

                    if(correspondingViewModel != null){
                        mappedResults.put(correspondingViewModel, (Class<? extends NMvxView>) x);
                    }
                });
    }

    @Override
    public HashMap<Class<? extends NMvxViewModel>, Class<? extends NMvxView>> getQueryResults() {
        return mappedResults != null ? mappedResults : new HashMap<Class<? extends NMvxViewModel>, Class<? extends NMvxView>>();
    }

    private Class<?> findCorrespondingViewModel(String viewName){
        Class<?> result = null;
        for(Class<?> clazz : results){
            String name = clazz.getSimpleName();
            if(name.equals(viewName.concat("ViewModel")) && NMvxViewModel.class.isAssignableFrom(clazz)){
                result = clazz;

                break;
            }
        }

        return result;

//        return Stream.of(results)
//                .filter(x -> x.getSimpleName().equals(viewName.concat("ViewModel"))
//                            && NMvxView.class.isAssignableFrom(x))
//                .findFirst()
//                .get();
    }

}
