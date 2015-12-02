package com.pahilomaya.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pahilomaya.request.AccountInfoRequest;
import com.pahilomaya.response.GetAccountsResponse;

public class AccountsTest extends BaseTest {

    AccountInfoRequest accReq = new AccountInfoRequest();
    private String data;

    @Before
    public void setup() {
        accReq.setUserId("hoaUser1");
        try {
            data = mapper.writeValueAsString(accReq);
            System.out.println(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test() throws Exception {
        conn = connect("accounts/list", data);
        GetAccountsResponse response = readResponse(conn, GetAccountsResponse.class);
        assertEquals(3, response.getAccounts().size());
    }

}
