package com.ducdm.nmvvm.dynamicscanner;

import com.ducdm.nmvvm.agents.finders.LoaderQuery;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;

/**
 * Created by DangManhDuc on 12/18/2016.
 */

public class NMvxDynamicScanner implements INMvxDynamicScanner {

    private static final char PKG_SEPARATOR = '.';
    private static final char DIR_SEPARATOR = '/';
    private static final String CLASS_FILE_SUFFIX = ".class";
    private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

    private String packageCodePath;

    public NMvxDynamicScanner(String packageCodePath){
        this.packageCodePath = packageCodePath;
    }

    @Override
    public LoaderQuery scan(String scannedPackage) {
        LoaderQuery results = new LoaderQuery();

        PathClassLoader classLoader = (PathClassLoader) Thread.currentThread().getContextClassLoader();

        try {
            DexFile dexFile = new DexFile(packageCodePath);
            Enumeration<String> classNames = dexFile.entries();
            while (classNames.hasMoreElements()) {
                String className = classNames.nextElement();
                if (className.startsWith(scannedPackage) && !className.contains("$")) {
                    Class<?> aClass = classLoader.loadClass(className);
                    results.add(aClass);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return results;
    }

//    @Override
//    public LoaderQuery scan(String scannedPackage) {
//        LoaderQuery results = new LoaderQuery();
//
//        String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
//        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
//
//        if (scannedUrl == null) {
//            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
//        }
//
//        File scannedDir = new File(scannedUrl.getFile());
//
//        for (File file : scannedDir.listFiles()) {
//            results.addAll(scan(file, scannedPackage));
//        }
//
//        return results;
//    }

    private List<Class<?>> scan(File file, String scannedPackage) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String resource = scannedPackage + PKG_SEPARATOR + file.getName();

        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                classes.addAll(scan(child, resource));
            }
        } else if (resource.endsWith(CLASS_FILE_SUFFIX)) {
            int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
            String className = resource.substring(0, endIndex);
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException ignore) {
                // Log something
            }
        }

        return classes;
    }

}
