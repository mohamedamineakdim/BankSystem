package model;

import exception.InsufficientFundException;
import exception.NotInRangeException;

public interface ITransaction {

    void deposit(double amount) throws NotInRangeException;

    void withdraw(double amount) throws InsufficientFundException, NotInRangeException;

    double checkBalance();

    void transfer(Account targetAccount, double amount)
            throws InsufficientFundException, NotInRangeException;
}