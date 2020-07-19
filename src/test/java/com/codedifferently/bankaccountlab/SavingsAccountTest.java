package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Test;

public class SavingsAccountTest {
    String name = "LeBron James";
    String password = "cavs";
    double initialDeposit = 9000000;
    SavingsAccount account;

    @Test
    public void constructorInstanceOfTest() {
        account = new SavingsAccount(name, password, initialDeposit);

        Assert.assertTrue(account instanceof BankAccount);
    }

    @Test
    public void constructorValuesTest() {
        account = new SavingsAccount(name, password, initialDeposit);

        String actualName = account.getName();
        String actualPassword = account.getPassword();
        double actualDeposit = account.getBalance();

        Assert.assertEquals(name, actualName);
        Assert.assertEquals(password, actualPassword);
        Assert.assertEquals(initialDeposit, actualDeposit, 0.00);
    }

    @Test
    public void getNameTest() {
        account = new SavingsAccount(name, password, initialDeposit);

        String expectedCompany = name;
        String actualName = account.getName();

        Assert.assertEquals(expectedCompany, actualName);
    }

    @Test
    public void setNameTest() {
        account = new SavingsAccount(name, password, initialDeposit);

        String expectedCompany = "JPMC";
        account.setName(expectedCompany);
        String actualName = account.getName();

        Assert.assertEquals(expectedCompany, actualName);
    }
}
