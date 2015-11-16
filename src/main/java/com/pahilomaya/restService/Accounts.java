package com.pahilomaya.restService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.pahilomaya.delegates.GetAccountDelegate;
import com.pahilomaya.request.BaseRequest;
import com.pahilomaya.response.GetAccountsResponse;

@Path("/accounts")
public class Accounts {

    private final Provider<GetAccountDelegate> getAccountDelegate;

    @Inject
    public Accounts(Provider<GetAccountDelegate> getAccountDelegate) {
        this.getAccountDelegate = getAccountDelegate;
    }

    @POST
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public GetAccountsResponse getAccountsByUser(BaseRequest accountResquest) throws Exception {
        System.out.println("Hello from Guice DI");
        return getAccountDelegate.get().go();
    }
}
