package model;

import exception.NotInRangeException;
import exception.NotNullException;
import validation.Validator;

public class Customer {

    private long customerId;
    private int nip;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Customer(long customerId, int nip, String firstName, String lastName, String email, String phone)
            throws NotNullException, NotInRangeException {

        setCustomerId(customerId);
        setNip(nip);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) throws NotInRangeException {
        Validator.validateId(customerId);
        this.customerId = customerId;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) throws NotInRangeException {
        Validator.validateNip(nip);
        this.nip = nip;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws NotNullException {
        Validator.validateString(firstName, "First name");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws NotNullException {
        Validator.validateString(lastName, "Last name");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws NotNullException {
        Validator.validateString(email, "Email");
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws NotNullException {
        Validator.validateString(phone, "Phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId +
                " | NIP: " + nip +
                " | Name: " + firstName + " " + lastName +
                " | Email: " + email +
                " | Phone: " + phone;
    }
}