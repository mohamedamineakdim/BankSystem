package model;

import enums.EnumAccountType;
import exception.NotInRangeException;

public class SavingAccount extends Account {

    private double annualInterestRate;

    public SavingAccount(long accountNumber, long customerId, double balance, double annualInterestRate)
            throws NotInRangeException {

        super(accountNumber, customerId, balance, EnumAccountType.SAVING);

        if (annualInterestRate < 0) {
            throw new NotInRangeException("Interest rate cannot be negative.");
        }

        this.annualInterestRate = annualInterestRate;
    }

    public double calculateAnnualGain() {
        return balance * annualInterestRate;
    }

    public void applyAnnualInterest() {
        balance += calculateAnnualGain();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Interest Rate: " + annualInterestRate +
                " | Annual Gain: " + calculateAnnualGain();
    }
}