package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class BankAccountTest {
    String name = "Victor";
    String password = "default";
    double initialDeposit = 5000000;
    CheckingAccount checkAccObj;

    @Test
    public void constructorAccountNumTest() {
        int numOfAccountsToCreate = 5;
        ArrayList<BankAccount> db = new ArrayList<>();
        for (int i = 0; i < numOfAccountsToCreate; i++) {
            db.add(new CheckingAccount("Blah", "default", 0));
        }
        // the account # of the last account is the previous number from count, since count
        // had already made the last account and incremented
        int expectedAccountNumber = BankAccount.count - 1;
        int actualAccountNumber = db.get(numOfAccountsToCreate - 1).getAccountNumber();

        Assert.assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    @Test
    public void getFeesTest() {
        checkAccObj = new CheckingAccount(name, password, initialDeposit);
        double expectedFees = 20;

        double actualFees = checkAccObj.getFees();

        Assert.assertEquals(expectedFees, actualFees, 0.00);
    }

    @Test
    public void setFeesTest() {
        checkAccObj = new CheckingAccount(name, password, initialDeposit);
        double expectedFees = 10;

        checkAccObj.setFees(expectedFees);
        double actualFees = checkAccObj.getFees();

        Assert.assertEquals(expectedFees, actualFees, 0.00);
    }

    @Test
    public void getBalanceTest() {
        checkAccObj = new CheckingAccount(name, password, initialDeposit);
        double expectedBalance = initialDeposit;

        double actualBalance = checkAccObj.getBalance();

        Assert.assertEquals(expectedBalance, actualBalance, 0.00);
    }

    @Test
    public void getPasswordTest() {
        checkAccObj = new CheckingAccount(name, password, initialDeposit);
        String expectedPassword = password;

        String actualPassword = checkAccObj.getPassword();

        Assert.assertEquals(expectedPassword, actualPassword);
    }

    @Test
    public void toStringTest() {
        String expectedObjName = Integer.toString(BankAccount.count);
        checkAccObj = new CheckingAccount(name, password, initialDeposit);

        String actualObjName = checkAccObj.toString();

        Assert.assertEquals(expectedObjName, actualObjName);

    }

    @Test
    public void equalsTest() {
        String expectedObjName = Integer.toString(BankAccount.count);
        checkAccObj = new CheckingAccount(name, password, initialDeposit);

        String actualObjName = checkAccObj.toString();

        Assert.assertTrue(expectedObjName.equals(actualObjName));
    }

    @Test
    public void depositTest() {
        checkAccObj = new CheckingAccount(name, password, initialDeposit);
        double depositAmount = 1;
        double expectedBalance = initialDeposit + depositAmount;

        checkAccObj.deposit(depositAmount);
        double actualBalance = checkAccObj.getBalance();

        Assert.assertEquals(expectedBalance, actualBalance, 0.00);
    }

    @Test
    public void withDrawTest() {
        checkAccObj = new CheckingAccount(name, password, initialDeposit);
        double withDrawAmount = 1;
        double expectedBalance = initialDeposit - withDrawAmount;

        checkAccObj.withdraw(withDrawAmount);
        double actualBalance = checkAccObj.getBalance();

        Assert.assertEquals(expectedBalance, actualBalance, 0.00);
    }
}
