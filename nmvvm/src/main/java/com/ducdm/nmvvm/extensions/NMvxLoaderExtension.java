package com.ducdm.nmvvm.extensions;

import com.annimon.stream.Stream;
import com.ducdm.nmvvm.agents.finders.IFilter;
import com.ducdm.nmvvm.agents.finders.LoaderQuery;
import com.ducdm.nmvvm.agents.finders.MapperQuery;
import com.ducdm.nmvvm.agents.models.NMvxServiceAndImplementationTypePair;
import com.ducdm.nmvvm.dynamicscanner.INMvxDynamicScanner;
import com.ducdm.nmvvm.mappings.NMvx;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static com.annimon.stream.Collectors.toList;

/**
 * Created by DangManhDuc on 12/17/2016.
 */

public class NMvxLoaderExtension {

    private static INMvxDynamicScanner dynamicScanner;
    private static LoaderQuery results = new LoaderQuery();
    private static MapperQuery mappedresults = new MapperQuery();

    private NMvxLoaderExtension(Builder builder){

    }

    public static class Builder implements IFilter {

        private String scannedPackage;

        public Builder(String scannedPackage){
            this.scannedPackage = scannedPackage;
            dynamicScanner = NMvx.resolve(INMvxDynamicScanner.class);
        }

        public Builder load(){
            results = dynamicScanner.scan(scannedPackage);
            results = new LoaderQuery(Stream.of(results)
                    .filter(x -> !Modifier.isAbstract(x.getModifiers()))
                    .filter(x -> {
                        return Stream.of(x.getDeclaredConstructors())
                                .filter(y -> !Modifier.isStatic(y.getModifiers()) && Modifier.isPublic(y.getModifiers())).count() > 0;
                    })
                    .map(x -> x)
                    .collect(toList()));

            return this;
        }

        @Override
        public Builder startsWith(final String prefix) {
            results = new LoaderQuery(Stream.of(results)
                    .filter(x -> x.getSimpleName().startsWith(prefix))
                    .map(x -> x)
                    .collect(toList()));

            return this;
        }

        @Override
        public Builder endsWith(String postfix) {
            results = new LoaderQuery(Stream.of(results)
                    .filter(x -> x.getSimpleName().endsWith(postfix))
                    .map(x -> x)
                    .collect(toList()));

            return this;
        }

        @Override
        public Builder contains(String specificSequence) {
            results = new LoaderQuery(Stream.of(results)
                    .filter(x -> x.getSimpleName().contains(specificSequence))
                    .map(x -> x)
                    .collect(toList()));

            return this;
        }

        @Override
        public Builder hasAttribute(Class<? extends Annotation> attribute) {
            results = new LoaderQuery(Stream.of(results)
                    .filter(x -> x.isAnnotationPresent(attribute))
                    .map(x -> x)
                    .collect(toList()));

            return this;
        }

        @Override
        public Builder inheritFrom(Class<?> base) {
            results = new LoaderQuery(Stream.of(results)
                    .filter(x -> base.isAssignableFrom(x))
                    .map(x -> x)
                    .collect(toList()));

            return this;
        }

        @Override
        public Builder doesNotInheritFrom(Class<?> base) {
            results = new LoaderQuery(Stream.of(results)
                    .filter(x -> !base.isAssignableFrom(x))
                    .map(x -> x)
                    .collect(toList()));

            return this;
        }

        public Builder queryInterfaces(){
            Stream.of(results)
                    .forEach(x ->
                    {
                        NMvxServiceAndImplementationTypePair mappedItem = new NMvxServiceAndImplementationTypePair(
                                Arrays.asList(x.getInterfaces()),
                                x);
                        mappedresults.add(mappedItem);
                    });

            return this;
        }

        public Builder registerType(){
            Stream.of(mappedresults)
                    .forEach(x ->
                    {
                        Stream.of(x.getServiceTypes())
                                .forEach(y -> NMvx.registerType((Class<?>) y, x.getImplementationType()));
                    });

            return this;
        }

        public void build(){
            new NMvxLoaderExtension(this);
        }

    }

}
