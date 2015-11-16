package com.pahilomaya.guice;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.pahilomaya.delegates.GetAccountDelegate;

public class ApplicationServletModule extends ServletModule {

    @Override
    protected void configureServlets() {

        // Install JavaMelody Monitoring module
        // install(new MonitoringGuiceModule());

    }

    @Provides
    @Singleton
    public GetAccountDelegate provideGetAccountDelegate() throws Exception {
        GetAccountDelegate getAccountDelegate = new GetAccountDelegate();
        return getAccountDelegate;
    }

}
