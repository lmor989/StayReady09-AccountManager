package com.codedifferently.bankaccountlab;

public class BusinessAccount extends BankAccount {
    private String company;
    private int taxId;

    public BusinessAccount(String company, String password, int taxId, double initialDeposit) {
        this.company = company;
        this.balance = initialDeposit;
        this.taxId = taxId;
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }
}
