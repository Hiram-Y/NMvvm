package com.ducdm.nmvvm.agents.finders;

import com.ducdm.nmvvm.extensions.NMvxLoaderExtension;

import java.lang.annotation.Annotation;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public interface IFilter {

    NMvxLoaderExtension.Builder startsWith(String prefix);
    NMvxLoaderExtension.Builder endsWith(String postfix);
    NMvxLoaderExtension.Builder contains(String specificSequence);
    NMvxLoaderExtension.Builder hasAttribute(Class<? extends Annotation> attribute);
    NMvxLoaderExtension.Builder inheritFrom(Class<?> base);
    NMvxLoaderExtension.Builder doesNotInheritFrom(Class<?> base);
    
}
