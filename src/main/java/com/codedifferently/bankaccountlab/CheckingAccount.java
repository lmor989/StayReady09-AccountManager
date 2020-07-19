package com.codedifferently.bankaccountlab;

;

public class CheckingAccount extends BankAccount {
    private String name;


    public CheckingAccount(String name, String password, double initialDeposit) {
        this.name = name;
        this.password = password;
        this.balance = initialDeposit;
        this.fees = 20;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
