package com.neoteric.javatdd.account;

import lombok.Data;

@Data
public class AccountEntity {

    private  String name;
    private String adderNumber;
    private  String accountNumber;
    private Addres address;
    private String fName;
    private  int age;
    private  double balance;

    public AccountEntity( String accountNumber,String name, double balance, int age) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.age = age;
        this.balance = balance;
    }
}
