package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import enums.EnumTransactionStatus;
import enums.EnumTransactionType;

public class TransactionDAO {

    public static boolean addTransaction(
            String description,
            double amount,
            EnumTransactionType type,
            EnumTransactionStatus status,
            long sourceAccount,
            long targetAccount) {

        String sql =
        "INSERT INTO BANK_TRANSACTION " +
        "(TRANSACTION_ID, DESCRIPTION, AMOUNT, TRANSACTION_TYPE, TRANSACTION_STATUS, SOURCE_ACCOUNT, TARGET_ACCOUNT) " +
        "VALUES (TRANSACTION_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, description);
            ps.setDouble(2, amount);
            ps.setString(3, type.name());
            ps.setString(4, status.name());
            ps.setLong(5, sourceAccount);
            ps.setLong(6, targetAccount);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void showTransactionsByAccount(long accountNumber) {

        String sql =
        "SELECT * FROM BANK_TRANSACTION " +
        "WHERE SOURCE_ACCOUNT=? OR TARGET_ACCOUNT=? " +
        "ORDER BY TRANSACTION_ID DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, accountNumber);
            ps.setLong(2, accountNumber);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getLong("TRANSACTION_ID") + " | " +
                    rs.getString("TRANSACTION_TYPE") + " | " +
                    rs.getDouble("AMOUNT") + " | " +
                    rs.getString("TRANSACTION_STATUS") + " | From: " +
                    rs.getLong("SOURCE_ACCOUNT") + " | To: " +
                    rs.getLong("TARGET_ACCOUNT") + " | " +
                    rs.getString("DESCRIPTION")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}