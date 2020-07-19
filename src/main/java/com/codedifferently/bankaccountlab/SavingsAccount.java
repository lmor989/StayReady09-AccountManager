package com.codedifferently.bankaccountlab;

public class SavingsAccount extends BankAccount {
    private String name;
    private double rate = 0;

    public SavingsAccount(String name, String password, double initialDeposit) {
        this.name = name;
        this.password = password;
        this.balance = initialDeposit;
        this.fees = 0;
        this.rate = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
