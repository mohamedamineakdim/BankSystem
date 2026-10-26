package model;

import java.util.Date;

import enums.EnumTransactionStatus;
import enums.EnumTransactionType;

public class Transaction {

    private long transactionId;
    private String description;
    private double amount;
    private Date transactionDate;
    private EnumTransactionType transactionType;
    private EnumTransactionStatus transactionStatus;
    private long sourceAccountNumber;
    private long targetAccountNumber;

    public Transaction(long transactionId,
                       String description,
                       double amount,
                       EnumTransactionType transactionType,
                       EnumTransactionStatus transactionStatus,
                       long sourceAccountNumber,
                       long targetAccountNumber) {

        this.transactionId = transactionId;
        this.description = description;
        this.amount = amount;
        this.transactionDate = new Date();
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
        this.sourceAccountNumber = sourceAccountNumber;
        this.targetAccountNumber = targetAccountNumber;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public EnumTransactionType getTransactionType() {
        return transactionType;
    }

    public EnumTransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public long getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public long getTargetAccountNumber() {
        return targetAccountNumber;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
                " | Type: " + transactionType +
                " | Amount: " + amount +
                " | Status: " + transactionStatus +
                " | Date: " + transactionDate +
                " | From: " + sourceAccountNumber +
                " | To: " + targetAccountNumber +
                " | Description: " + description;
    }
}