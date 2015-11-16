package com.pahilomaya.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class ListenerConfig extends GuiceServletContextListener {

    private static Injector INJECTOR = null;

    @Override
    protected Injector getInjector() {
        if (INJECTOR == null) {
            INJECTOR = Guice.createInjector(new ApplicationServletModule());
        }
        return INJECTOR;
    }

    public static Injector get() {
        return INJECTOR;
    }
}
