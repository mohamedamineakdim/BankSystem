package model;

import enums.EnumAccountType;
import exception.NotInRangeException;
import exception.NotNullException;
import validation.Validator;

public class CurrencyAccount extends Account {

    private String currency;
    private boolean active;

    public CurrencyAccount(long accountNumber, long customerId, double balance, String currency)
            throws NotInRangeException, NotNullException {

        super(accountNumber, customerId, balance, EnumAccountType.CURRENCY);

        Validator.validateString(currency, "Currency");

        this.currency = currency;
        this.active = true;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isActive() {
        return active;
    }

    public void closeIfInactiveOneYear() {
        active = false;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Currency: " + currency +
                " | Active: " + active;
    }
}