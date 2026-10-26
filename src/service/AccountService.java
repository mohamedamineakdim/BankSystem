package service;

import dao.AccountDAO;
import dao.CustomerDAO;
import enums.EnumAccountType;

public class AccountService {

    public static boolean createAccount(int nip, double initialBalance, EnumAccountType type) {

        long customerId = CustomerDAO.getCustomerIdByNip(nip);

        if (customerId == -1) {
            System.out.println("Customer not found!");
            return false;
        }

        return AccountDAO.createAccount(customerId, initialBalance, type);
    }

    public static void showAccounts(int nip) {

        long customerId = CustomerDAO.getCustomerIdByNip(nip);

        if (customerId == -1) {
            System.out.println("Customer not found!");
            return;
        }

        AccountDAO.showAccountsByCustomer(customerId);
    }

    public static boolean closeAccount(long accountNumber) {

        if (!AccountDAO.accountExists(accountNumber)) {
            System.out.println("Account does not exist!");
            return false;
        }

        return AccountDAO.closeAccount(accountNumber);
    }
}