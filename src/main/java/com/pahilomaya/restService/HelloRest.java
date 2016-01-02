package com.pahilomaya.restService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pahilo")
public class HelloRest {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        System.out.println("sayHello called");
        String ret = "Want to say Hello \n" + "Where did you go?? \n " + "last line of code";
        return ret;
    }
}
