package com.codedifferently.bankaccountlab;

public abstract class BankAccount {
    static int count = 1;
    protected int accountNumber;
    protected double fees;
    protected double balance;
    protected String password;

    public BankAccount() {
        this.accountNumber = count;
        count++;
        System.out.println("Your account has been created!");
        System.out.println("Your account number is " + accountNumber);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return Integer.toString(accountNumber);
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }

    public void deposit(double num) {
        this.balance += num;
    }

    public void withdraw(double num) {
        this.balance -= num;
    }
}
