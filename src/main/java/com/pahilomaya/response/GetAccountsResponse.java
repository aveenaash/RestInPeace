package com.pahilomaya.response;

import java.util.List;

import com.pahilomaya.entities.Account;

public class GetAccountsResponse extends BaseResponse {

    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
