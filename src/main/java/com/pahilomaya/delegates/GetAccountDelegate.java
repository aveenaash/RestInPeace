package com.pahilomaya.delegates;

import com.pahilomaya.response.GetAccountsResponse;
import com.pahilomaya.testdata.TestData;

public class GetAccountDelegate {

    public GetAccountsResponse go() {
        GetAccountsResponse response = new GetAccountsResponse();
        response.setAccounts(TestData.createAccountTestData());
        response.setSuccess(true);
        System.out.println("before return");
        return response;
    }
}
