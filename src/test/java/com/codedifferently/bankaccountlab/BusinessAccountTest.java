package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Test;

public class BusinessAccountTest {
    String companyName = "Code Differently";
    String password = "default";
    int taxId = 007;
    double initialDeposit = 250;
    BusinessAccount account;

    @Test
    public void constructorInstanceOfTest() {
        account = new BusinessAccount(companyName, password, taxId, initialDeposit);

        Assert.assertTrue(account instanceof BankAccount);
    }

    @Test
    public void constructorValuesTest() {
        account = new BusinessAccount(companyName, password, taxId, initialDeposit);

        String actualCompany = account.getCompany();
        String actualPassword = account.getPassword();
        int actualTaxId = account.getTaxId();
        double actualDeposit = account.getBalance();

        Assert.assertEquals(companyName, actualCompany);
        Assert.assertEquals(password, actualPassword);
        Assert.assertEquals(taxId, actualTaxId);
        Assert.assertEquals(initialDeposit, actualDeposit, 0.00);
    }

    @Test
    public void getCompanyTest() {
        account = new BusinessAccount(companyName, password, taxId, initialDeposit);

        String expectedCompany = companyName;
        String actualCompany = account.getCompany();

        Assert.assertEquals(expectedCompany, actualCompany);
    }

    @Test
    public void setCompanyTest() {
        account = new BusinessAccount(companyName, password, taxId, initialDeposit);

        String expectedCompany = "JPMC";
        account.setCompany(expectedCompany);
        String actualCompany = account.getCompany();

        Assert.assertEquals(expectedCompany, actualCompany);
    }

    @Test
    public void getTaxIdTest() {
        account = new BusinessAccount(companyName, password, taxId, initialDeposit);

        int expectedTaxId = taxId;
        int actualTaxId = account.getTaxId();

        Assert.assertEquals(expectedTaxId, actualTaxId);
    }

    @Test
    public void setTaxIdTest() {
        account = new BusinessAccount(companyName, password, taxId, initialDeposit);

        int expectedTaxId = 95042;
        account.setTaxId(expectedTaxId);
        int actualTaxId = account.getTaxId();

        Assert.assertEquals(expectedTaxId, actualTaxId);
    }
}
