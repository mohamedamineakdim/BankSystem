package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.EnumAccountType;
import exception.InsufficientFundException;
import exception.NotInRangeException;
import validation.Validator;

public abstract class Account implements ITransaction {

    protected long accountNumber;
    protected long customerId;
    protected double balance;
    protected Date openingDate;
    protected EnumAccountType accountType;
    protected List<Transaction> transactions;

    public Account(long accountNumber, long customerId, double balance, EnumAccountType accountType)
            throws NotInRangeException {

        Validator.validateId(accountNumber);
        Validator.validateId(customerId);

        if (balance < 0) {
            throw new NotInRangeException("Balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = balance;
        this.accountType = accountType;
        this.openingDate = new Date();
        this.transactions = new ArrayList<Transaction>();
    }

    @Override
    public void deposit(double amount) throws NotInRangeException {
        Validator.validatePositiveAmount(amount);
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundException, NotInRangeException {
        Validator.validatePositiveAmount(amount);

        if (amount > balance) {
            throw new InsufficientFundException("Insufficient funds.");
        }

        balance -= amount;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public void transfer(Account targetAccount, double amount)
            throws InsufficientFundException, NotInRangeException {

        withdraw(amount);
        targetAccount.deposit(amount);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public double getBalance() {
        return balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public EnumAccountType getAccountType() {
        return accountType;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                " | Customer ID: " + customerId +
                " | Type: " + accountType +
                " | Balance: " + balance;
    }
}