package com.pahilomaya.testdata;

import java.util.ArrayList;
import java.util.List;

import com.pahilomaya.entities.Account;

public class TestData {

    public static List<Account> createAccountTestData() {
        List<Account> accList = new ArrayList<Account>();
        Account acc1 = new Account("00912891889", "1298.89", "thotro");
        Account acc2 = new Account("00912812354", "18.56", "checkings");
        Account acc3 = new Account("00912898209", "18976.08", "naya");
        accList.add(acc1);
        accList.add(acc2);
        accList.add(acc3);
        return accList;
    }
}
