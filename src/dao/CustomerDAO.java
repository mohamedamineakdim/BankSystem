package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {

    public static boolean addCustomer(int nip, String first, String last, String email, String phone) {

        String sql =
        "INSERT INTO CUSTOMER (CUSTOMER_ID, NIP, FIRST_NAME, LAST_NAME, EMAIL, PHONE) " +
        "VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nip);
            ps.setString(2, first);
            ps.setString(3, last);
            ps.setString(4, email);
            ps.setString(5, phone);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateCustomer(long id, int nip, String first, String last, String email, String phone) {

        String sql =
        "UPDATE CUSTOMER SET NIP=?, FIRST_NAME=?, LAST_NAME=?, EMAIL=?, PHONE=? " +
        "WHERE CUSTOMER_ID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nip);
            ps.setString(2, first);
            ps.setString(3, last);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setLong(6, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteCustomer(long id) {

        String sql = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void showCustomers() {

        String sql = "SELECT * FROM CUSTOMER ORDER BY CUSTOMER_ID";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                    rs.getLong("CUSTOMER_ID") + " | " +
                    rs.getInt("NIP") + " | " +
                    rs.getString("FIRST_NAME") + " " +
                    rs.getString("LAST_NAME") + " | " +
                    rs.getString("EMAIL") + " | " +
                    rs.getString("PHONE")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean customerExists(long id) {

        String sql = "SELECT CUSTOMER_ID FROM CUSTOMER WHERE CUSTOMER_ID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static long getCustomerIdByNip(int nip) {

        String sql = "SELECT CUSTOMER_ID FROM CUSTOMER WHERE NIP=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nip);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getLong("CUSTOMER_ID");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}