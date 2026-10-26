package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import enums.EnumAccountType;

public class AccountDAO {

    public static boolean createAccount(long customerId, double balance, EnumAccountType type) {

        String sql =
        "INSERT INTO ACCOUNT (ACCOUNT_NUMBER, CUSTOMER_ID, BALANCE, ACCOUNT_TYPE) " +
        "VALUES (ACCOUNT_SEQ.NEXTVAL, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, customerId);
            ps.setDouble(2, balance);
            ps.setString(3, type.name());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateBalance(long accountNumber, double newBalance) {

        String sql = "UPDATE ACCOUNT SET BALANCE=? WHERE ACCOUNT_NUMBER=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, newBalance);
            ps.setLong(2, accountNumber);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static double getBalance(long accountNumber) {

        String sql = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNT_NUMBER=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("BALANCE");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static boolean accountExists(long accountNumber) {

        String sql = "SELECT ACCOUNT_NUMBER FROM ACCOUNT WHERE ACCOUNT_NUMBER=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void showAccountsByCustomer(long customerId) {

        String sql = "SELECT * FROM ACCOUNT WHERE CUSTOMER_ID=? ORDER BY ACCOUNT_NUMBER";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, customerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getLong("ACCOUNT_NUMBER") + " | " +
                    rs.getString("ACCOUNT_TYPE") + " | Balance: " +
                    rs.getDouble("BALANCE")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean closeAccount(long accountNumber) {

        String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_NUMBER=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, accountNumber);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}