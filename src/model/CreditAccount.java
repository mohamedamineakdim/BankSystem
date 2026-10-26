package model;

import enums.EnumAccountType;
import exception.InsufficientFundException;
import exception.NotInRangeException;
import validation.Validator;

public class CreditAccount extends Account {

    private double creditLimit;
    private double annualInterestRate;

    public CreditAccount(long accountNumber, long customerId, double balance,
                         double creditLimit, double annualInterestRate)
            throws NotInRangeException {

        super(accountNumber, customerId, balance, EnumAccountType.CREDIT);

        Validator.validatePositiveAmount(creditLimit);

        if (annualInterestRate < 0) {
            throw new NotInRangeException("Interest rate cannot be negative.");
        }

        this.creditLimit = creditLimit;
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundException, NotInRangeException {
        Validator.validatePositiveAmount(amount);

        if (amount > balance + creditLimit) {
            throw new InsufficientFundException("Credit limit exceeded.");
        }

        balance -= amount;
    }

    public double calculateInterestOnBorrowedAmount() {
        if (balance >= 0) {
            return 0;
        }

        return Math.abs(balance) * annualInterestRate;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Credit Limit: " + creditLimit +
                " | Interest Rate: " + annualInterestRate;
    }
}