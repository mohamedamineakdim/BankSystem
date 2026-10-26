package service;

import dao.CustomerDAO;

public class CustomerService {

    public static boolean createCustomer(int nip, String first, String last, String email, String phone) {

        return CustomerDAO.addCustomer(nip, first, last, email, phone);
    }

    public static boolean updateCustomer(long id, int nip, String first, String last, String email, String phone) {

        return CustomerDAO.updateCustomer(id, nip, first, last, email, phone);
    }

    public static boolean deleteCustomer(long id) {

        return CustomerDAO.deleteCustomer(id);
    }

    public static void showCustomers() {

        CustomerDAO.showCustomers();
    }

    public static long getCustomerIdByNip(int nip) {

        return CustomerDAO.getCustomerIdByNip(nip);
    }
}