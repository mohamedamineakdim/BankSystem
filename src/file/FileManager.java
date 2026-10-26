package file;

import java.io.FileWriter;
import java.io.PrintWriter;
import model.Account;
import data.BankDataCollection;

public class FileManager {

    // SAVE ACCOUNTS TO FILE
    public static void saveAccounts() {

        try {

            PrintWriter pw = new PrintWriter(
                    new FileWriter("accounts.txt")
            );

            for (Account a : BankDataCollection.accounts) {

                pw.println(
                        a.getAccountNumber() + "," + a.getBalance()
                );
            }

            pw.close();

            System.out.println("Accounts saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}