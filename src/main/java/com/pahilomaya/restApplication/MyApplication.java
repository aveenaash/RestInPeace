package com.pahilomaya.restApplication;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.google.inject.Injector;
import com.pahilomaya.guice.ListenerConfig;
import com.pahilomaya.restService.Accounts;
import com.pahilomaya.restService.HelloRest;

@ApplicationPath("/api")
public class MyApplication extends Application {

    @Override
    public Set<Object> getSingletons() {
        Set<Object> objects = new HashSet<Object>();

        // statically reference the INJECTOR to bridge frameworks like JAXRS and Guice
        Injector in = ListenerConfig.get();

        objects.add(in.getInstance(HelloRest.class));
        objects.add(in.getInstance(Accounts.class));

        // If using JacksonJSON u should get instance of it also
        JacksonJaxbJsonProvider jsonProvider = in.getInstance(JacksonJaxbJsonProvider.class);

        ObjectMapper objectMapper = new ObjectMapper();
        jsonProvider.setMapper(objectMapper);
        objects.add(jsonProvider);

        return objects;

    }
}