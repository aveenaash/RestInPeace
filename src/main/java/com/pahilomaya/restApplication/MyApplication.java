package com.pahilomaya.restApplication;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.pahilomaya.restService.HelloRest;

public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(HelloRest.class);
        return s;
    }
}