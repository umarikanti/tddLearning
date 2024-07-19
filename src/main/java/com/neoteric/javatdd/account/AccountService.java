package com.neoteric.javatdd.account;

import com.neoteric.javatdd.account.AccountEntity;

public class AccountService {

    public static AccountEntity createAccount(String accountNumber, String accountHolderName, double initialBalance, int age) {
        if (age < 18) {
            System.out.println("Account holder must be at least 18 years old.");
            return null;
        }
        if (initialBalance < 5000) {
            System.out.println("Initial balance must be at least 5000.");
            return null;
        }
        return new AccountEntity(accountNumber, accountHolderName, initialBalance, age);
    }


}
