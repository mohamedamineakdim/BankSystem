package service;

import dao.AccountDAO;
import dao.TransactionDAO;
import enums.EnumTransactionStatus;
import enums.EnumTransactionType;

public class TransactionService {

    //  DEPOSIT
    public static boolean deposit(long accountNumber, double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return false;
        }

        if (!AccountDAO.accountExists(accountNumber)) {
            System.out.println("Account not found!");
            return false;
        }

        double balance = AccountDAO.getBalance(accountNumber);
        double newBalance = balance + amount;

        boolean updated = AccountDAO.updateBalance(accountNumber, newBalance);

        if (updated) {
            TransactionDAO.addTransaction(
                    "Deposit",
                    amount,
                    EnumTransactionType.DEPOSIT,
                    EnumTransactionStatus.SUCCESS,
                    accountNumber,
                    accountNumber
            );
        }

        return updated;
    }

    //  WITHDRAW
    public static boolean withdraw(long accountNumber, double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return false;
        }

        if (!AccountDAO.accountExists(accountNumber)) {
            System.out.println("Account not found!");
            return false;
        }

        double balance = AccountDAO.getBalance(accountNumber);

        if (amount > balance) {
            System.out.println("Insufficient funds!");
            return false;
        }

        double newBalance = balance - amount;

        boolean updated = AccountDAO.updateBalance(accountNumber, newBalance);

        if (updated) {
            TransactionDAO.addTransaction(
                    "Withdraw",
                    amount,
                    EnumTransactionType.WITHDRAW,
                    EnumTransactionStatus.SUCCESS,
                    accountNumber,
                    accountNumber
            );
        }

        return updated;
    }

    // TRANSFER
    public static boolean transfer(long fromAccount, long toAccount, double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return false;
        }

        if (!AccountDAO.accountExists(fromAccount) || !AccountDAO.accountExists(toAccount)) {
            System.out.println("One account not found!");
            return false;
        }

        double fromBalance = AccountDAO.getBalance(fromAccount);

        if (amount > fromBalance) {
            System.out.println("Insufficient funds!");
            return false;
        }

        double newFromBalance = fromBalance - amount;
        double toBalance = AccountDAO.getBalance(toAccount);
        double newToBalance = toBalance + amount;

        boolean update1 = AccountDAO.updateBalance(fromAccount, newFromBalance);
        boolean update2 = AccountDAO.updateBalance(toAccount, newToBalance);

        if (update1 && update2) {

            TransactionDAO.addTransaction(
                    "Transfer",
                    amount,
                    EnumTransactionType.TRANSFER,
                    EnumTransactionStatus.SUCCESS,
                    fromAccount,
                    toAccount
            );

            return true;
        }

        return false;
    }

    // CHECK BALANCE
    public static void checkBalance(long accountNumber) {

        if (!AccountDAO.accountExists(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }

        double balance = AccountDAO.getBalance(accountNumber);

        System.out.println("Balance: " + balance);
    }

    //  HISTORY
    public static void showHistory(long accountNumber) {

        if (!AccountDAO.accountExists(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }

        TransactionDAO.showTransactionsByAccount(accountNumber);
    }
    public static double getBalance(long accountNumber) {
        return AccountDAO.getBalance(accountNumber);
    }
}