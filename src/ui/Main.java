package ui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            String[] options = {"Manager", "Customer"};

            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose mode",
                    "Bank System",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == 0) {
                new BankManagerUI();
            } else if (choice == 1) {
                new BankCustomerUI();
            } else {
                System.exit(0);
            }

        });
    }
}