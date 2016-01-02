package com.pahilomaya.delegates;

import com.pahilomaya.response.GetAccountsResponse;
import com.pahilomaya.testdata.TestData;

public class GetAccountDelegate {

    public GetAccountsResponse go() {
        GetAccountsResponse response = new GetAccountsResponse();
        response.setAccounts(TestData.createAccountTestData());
        response.setSuccess(true);
        response.setResponseMessage("Your deposit has been submitted!\\Please write \"Electronically Presented\" "
                + "on your check.<br>Keep the paper copy for 15 days, then shred it.");
        System.out.println("before return");
        return response;
    }
}
