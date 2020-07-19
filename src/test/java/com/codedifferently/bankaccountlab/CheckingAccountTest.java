package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Test;

public class CheckingAccountTest {
    String name = "Kevin Durant";
    String password = "Thunder";
    double initialDeposit = 700.50;
    CheckingAccount account;

    @Test
    public void constructorInstanceOfTest() {
        account = new CheckingAccount(name, password, initialDeposit);

        Assert.assertTrue(account instanceof BankAccount);
    }

    @Test
    public void constructorValuesTest() {
        account = new CheckingAccount(name, password, initialDeposit);

        String actualName = account.getName();
        String actualPassword = account.getPassword();
        double actualDeposit = account.getBalance();

        Assert.assertEquals(name, actualName);
        Assert.assertEquals(password, actualPassword);
        Assert.assertEquals(initialDeposit, actualDeposit, 0.00);
    }

    @Test
    public void getNameTest() {
        account = new CheckingAccount(name, password, initialDeposit);

        String expectedCompany = name;
        String actualName = account.getName();

        Assert.assertEquals(expectedCompany, actualName);
    }

    @Test
    public void setNameTest() {
        account = new CheckingAccount(name, password, initialDeposit);

        String expectedCompany = "JPMC";
        account.setName(expectedCompany);
        String actualName = account.getName();

        Assert.assertEquals(expectedCompany, actualName);
    }
}
