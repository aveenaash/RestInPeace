package com.pahilomaya.guice;

import javax.xml.ws.BindingProvider;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.pahilomaya.delegates.GetAccountDelegate;
import com.soap.service.GetAccountServiceImpl;
import com.soap.service.GetAccountServiceImplService;

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

    @Provides
    public GetAccountServiceImpl provideVoyagerDelegate() throws Exception {

        GetAccountServiceImplService soapService = new GetAccountServiceImplService();
        GetAccountServiceImpl service = soapService.getGetAccountServiceImplPort();
        BindingProvider bp = (BindingProvider) service;
        return service;
    }
}
