package model;

import enums.EnumAccountType;
import exception.InsufficientFundException;
import exception.NotInRangeException;
import validation.Validator;

public class CreditLineAccount extends Account {

    private double creditLimit;
    private double annualInterestRate;

    public CreditLineAccount(long accountNumber, long customerId, double balance,
                             double creditLimit, double annualInterestRate)
            throws NotInRangeException {

        super(accountNumber, customerId, balance, EnumAccountType.CREDIT_LINE);

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
            throw new InsufficientFundException("Credit line limit exceeded.");
        }

        balance -= amount;
    }

    public void repay(double amount) throws NotInRangeException {
        deposit(amount);
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
}