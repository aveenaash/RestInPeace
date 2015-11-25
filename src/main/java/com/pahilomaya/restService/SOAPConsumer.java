package com.pahilomaya.restService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.soap.service.Account;
import com.soap.service.GetAccountServiceImpl;

@Path("/soapconsumer")
public class SOAPConsumer {

    private final Provider<GetAccountServiceImpl> soapDelegeate;

    @Inject
    public SOAPConsumer(Provider<GetAccountServiceImpl> soapDelegeate) {
        this.soapDelegeate = soapDelegeate;
    }

    @GET
    @Path("/getSoap")
    @Produces(MediaType.APPLICATION_JSON)
    public Account useMethodFromSOAP(@QueryParam("id") String id) {
        Account acc = soapDelegeate.get().getAccountById(id);
        System.out.println(acc.toString());
        return acc;
    }
}
