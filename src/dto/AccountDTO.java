package dto;

import enums.EnumAccountType;

public class AccountDTO {

    private long accountNumber;
    private long customerId;
    private double balance;
    private EnumAccountType accountType;

    public AccountDTO(long accountNumber, long customerId, double balance, EnumAccountType accountType) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = balance;
        this.accountType = accountType;
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

    public EnumAccountType getAccountType() {
        return accountType;
    }
}