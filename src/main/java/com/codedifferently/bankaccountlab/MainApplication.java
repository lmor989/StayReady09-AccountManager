package com.codedifferently.bankaccountlab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApplication {
    private static ArrayList<BankAccount> database = new ArrayList<>();
    private Scanner scannerObj = new Scanner(System.in);
    private int inputNum;
    private String inputString;
    int index = 0;
    public static final Logger log = Logger.getGlobal();

    public static void main(String[] args){
        MainApplication atm = new MainApplication();
        BankAccount acc1 = new CheckingAccount("Bob", "pw", 500);
        BankAccount acc2 = new SavingsAccount("Willy", "default", 700);
        atm.database.add(acc1);
        atm.database.add(acc2);
        atm.mainMenu();
    }

    public void mainMenu() {
        System.out.println("You are now at the main menu. Please select from the options below");
        displayOptionsMainMenu();
    }

    public void displayOptionsMainMenu() {
        System.out.println("1) Create an Account\n2) Login\n3) Account Database(Debug Purposes)\n4) Exit");
        try {
            inputNum = scannerObj.nextInt();
            switch (inputNum) {
                case 1:
                    createAnAccountChoices();
                case 2:
                    login();
                case 3:
                    showAccounts();
                case 4:
                    System.exit(0);
                default:
                    System.out.println("You've chosen a number not on the available options, please try again");
                    displayOptionsMainMenu();
            }
        } catch(InputMismatchException error) {
            System.out.println("Your input was not a number");
            log.log(Level.WARNING, "User did not input a number when at the main menu");
            scannerObj.nextLine();
            mainMenu();
        }
    }

    public void createAnAccountChoices() throws InputMismatchException {
        System.out.println("Which type of account would you like to create?");
        System.out.println("1) Checking Account\n2) Savings Account\n3) Business Account\n4) Exit");
        try {
            //scannerObj.hasNextInt();
            inputNum = scannerObj.nextInt();
            switch (inputNum){
                case 1:
                    makeCheckings();
                case 2:
                    makeSavings();
                case 3:
                    makeBusiness();
                case 4:
                    System.exit(0);
                default:
                    System.out.println("You've chosen a number not on the available options, please try again");
                    createAnAccountChoices();
            }
        } catch(InputMismatchException err) {
            System.out.println("Your input did not match the criteria");
            log.log(Level.SEVERE, "User's input was not a number when selecting to create a type of account");
            scannerObj.nextLine();
            createAnAccountChoices();
        }
    }

    public void makeCheckings() throws InputMismatchException {
        System.out.println("What is your name?");
        String name = scannerObj.next();
        System.out.println("What is your password?");
        String password = scannerObj.next();
        System.out.println("How much is your initial deposit?");
        double initialDeposit = scannerObj.nextDouble();
        BankAccount newAccount = new CheckingAccount(name, password, initialDeposit);
        database.add(newAccount);
        mainMenu();
    }

    public void makeSavings() throws InputMismatchException {
        System.out.println("What is your name?");
        String name = scannerObj.next();
        System.out.println("What is your password?");
        String password = scannerObj.next();
        System.out.println("How much is your initial deposit?");
        double initialDeposit = scannerObj.nextDouble();
        BankAccount newAccount = new SavingsAccount(name, password, initialDeposit);
        database.add(newAccount);
        mainMenu();
    }

    public void makeBusiness() throws InputMismatchException{
        System.out.println("What is your company name?");
        String name = scannerObj.next();
        System.out.println("What is your password?");
        String password = scannerObj.next();
        System.out.println("What is your taxId?");
        int taxId = scannerObj.nextInt();
        System.out.println("How much is your initial deposit?");
        double initialDeposit = scannerObj.nextDouble();
        BankAccount newAccount = new BusinessAccount(name, password, taxId, initialDeposit);
        database.add(newAccount);
        mainMenu();
    }

    public void login() throws InputMismatchException{
        System.out.println("What is your account number?");
        inputNum = scannerObj.nextInt();
        if (contains(inputNum)) {
            System.out.println("Account exists, what is your account password?");
            inputString = scannerObj.next();
            if (database.get(index).getPassword().equals(inputString)) {
                System.out.println("Log in successful");
                loginOptions();
            } else {
                System.out.println("Wrong password entered");
                System.out.println("1)Retry Login\n2) Return to main menu\n3) Exit");
                inputNum = scannerObj.nextInt();
                loginWrong();
                }
            } else {
            System.out.println("Account does not exist, returning to main manu");
            mainMenu();
        }
    }

    public void loginWrong() {
        switch (inputNum) {
            case 1:
                login();
            case 2:
                mainMenu();
            case 3:
                System.exit(0);
        }

    }

    public void loginOptions() throws InputMismatchException {
        System.out.println("What would you like to do?");
        System.out.println("1) Deposit\n2) Withdraw\n3) Check Balance\n4) Delete Account\n5) Log out");
        inputNum = scannerObj.nextInt();
        loginDecision();

    }

    public void loginDecision() {
        switch (inputNum) {
            case 1:
                deposit();
            case 2:
                withdraw();
            case 3:
                checkBalance();
            case 4:
                deleteAccount();
            case 5:
                logout();
        }
    }

    public void deposit() {
        System.out.println("Please enter amount you are depositing");
        inputNum = scannerObj.nextInt();
        database.get(index).deposit(inputNum);
        System.out.println("You have deposited $" + inputNum + " into your account");
        System.out.println("New balance is " + database.get(index).getBalance());
        loginOptions();
    }

    public void withdraw() {
        System.out.println("Please enter amount you are withdrawing");
        inputNum = scannerObj.nextInt();
        if (inputNum > database.get(index).getBalance()) {
            System.out.println("Your withdraw amount exceeds your balance");
            loginOptions();
        } else {
            database.get(index).withdraw(inputNum);
            System.out.println("You have withdrawn $" + inputNum + " from your account");
            System.out.println("New balance is " + database.get(index).getBalance());
            loginOptions();
        }
    }

    public void checkBalance() {
        System.out.println("Balance is " + database.get(index).getBalance());
        loginOptions();
    }

    public void logout() {
        System.out.println("Log out successful");
        index = 0;
        mainMenu();
    }

    public void deleteAccount() {
        database.remove(index);
        System.out.println("Account deleted");
        mainMenu();
    }

    public void showAccounts() {
        System.out.println();
        for (int i = 0; i < database.size(); i++) {
            System.out.println("Account Number: " + database.get(i).getAccountNumber() +
                    "\tPassword: " + database.get(i).getPassword() +
                    "\tBalance: " + database.get(i).getBalance());
        }
        System.out.println();
        mainMenu();
    }

    public boolean contains(int accountNumber) {
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getAccountNumber() == accountNumber) {
                index = i;
                return true;
            }
        }
        return false;
    }
}
