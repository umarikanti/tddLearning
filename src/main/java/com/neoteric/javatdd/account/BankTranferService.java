package com.neoteric.javatdd.account;

import com.neoteric.javatdd.account.AccountEntity;
import com.neoteric.javatdd.account.AccountService;

public class BankTranferService {

    public BankTranferService(){
        AccountService accountService = new AccountService();
    }


    public void deposit(AccountEntity accountEntity, double amount) {
        if (amount > 0) {
            double newBalance = accountEntity.getBalance() + amount;
            accountEntity.setBalance(newBalance);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(AccountEntity accountEntity, double amount) {
        if (amount > 0 && amount <= accountEntity.getBalance()) {
            double newBalance = accountEntity.getBalance() - amount;
            accountEntity.setBalance(newBalance);
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }
}
