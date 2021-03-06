package com.dfire.platform.alchemy.util;

public class ThreadLocalClassLoader {

    private static final ThreadLocal<ClassLoader> LOADER = new ThreadLocal<ClassLoader>(){
        @Override
        protected ClassLoader initialValue() {
            return Thread.currentThread().getContextClassLoader();
        }
    };

    public static void set(ClassLoader classLoader){
        LOADER.set(Thread.currentThread().getContextClassLoader());
        Thread.currentThread().setContextClassLoader(classLoader);
    }

    public static ClassLoader get(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static void clear(){
        Thread.currentThread().setContextClassLoader(LOADER.get());
        LOADER.remove();
    }

}
