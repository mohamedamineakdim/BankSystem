package model;

import enums.EnumAccountType;
import exception.InsufficientFundException;
import exception.NotInRangeException;

public class ChequingAccount extends Account {

    private int monthlyTransactionCount;
    private static final int FREE_TRANSACTION_LIMIT = 2;
    private static final double TRANSACTION_FEE = 5.0;

    public ChequingAccount(long accountNumber, long customerId, double balance)
            throws NotInRangeException {

        super(accountNumber, customerId, balance, EnumAccountType.CHEQUING);
        this.monthlyTransactionCount = 0;
    }

    @Override
    public void deposit(double amount) throws NotInRangeException {
        super.deposit(amount);
        applyFeeIfNeeded();
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundException, NotInRangeException {
        super.withdraw(amount);
        applyFeeIfNeeded();
    }

    private void applyFeeIfNeeded() {
        monthlyTransactionCount++;

        if (monthlyTransactionCount > FREE_TRANSACTION_LIMIT) {
            balance -= TRANSACTION_FEE;
        }
    }

    public int getMonthlyTransactionCount() {
        return monthlyTransactionCount;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Monthly Transactions: " + monthlyTransactionCount;
    }
}