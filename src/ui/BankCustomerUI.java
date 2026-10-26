package ui;

import javax.swing.*;
import java.awt.*;

import service.TransactionService;

public class BankCustomerUI extends JFrame {

    public BankCustomerUI() {

        setTitle("Bank Customer Panel");
        setSize(450,500);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("CUSTOMER PANEL");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(100,20,300,30);
        add(title);

        JButton balanceBtn = new JButton("Check Balance");
        balanceBtn.setBounds(120,80,200,35);
        add(balanceBtn);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(120,130,200,35);
        add(depositBtn);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(120,180,200,35);
        add(withdrawBtn);

        JButton transferBtn = new JButton("Transfer");
        transferBtn.setBounds(120,230,200,35);
        add(transferBtn);

        JButton historyBtn = new JButton("Transaction History");
        historyBtn.setBounds(120,280,200,35);
        add(historyBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(120,340,200,35);
        add(exitBtn);

        // CHECK BALANCE
        balanceBtn.addActionListener(e -> {
            try {
                long acc = Long.parseLong(JOptionPane.showInputDialog("Enter Account ID:"));
                double balance = TransactionService.getBalance(acc);

                JOptionPane.showMessageDialog(null, "Balance = " + balance);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        });

        // DEPOSIT
        depositBtn.addActionListener(e -> {
            try {
                long acc = Long.parseLong(JOptionPane.showInputDialog("Account ID:"));
                double amt = Double.parseDouble(JOptionPane.showInputDialog("Amount:"));

                boolean ok = TransactionService.deposit(acc, amt);

                if (ok)
                    JOptionPane.showMessageDialog(null, "Deposit Successful");
                else
                    JOptionPane.showMessageDialog(null, "Deposit Failed");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        });

        //  WITHDRAW
        withdrawBtn.addActionListener(e -> {
            try {
                long acc = Long.parseLong(JOptionPane.showInputDialog("Account ID:"));
                double amt = Double.parseDouble(JOptionPane.showInputDialog("Amount:"));

                boolean ok = TransactionService.withdraw(acc, amt);

                if (ok)
                    JOptionPane.showMessageDialog(null, "Withdraw Successful");
                else
                    JOptionPane.showMessageDialog(null, "Insufficient Funds");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        });

        //  TRANSFER
        transferBtn.addActionListener(e -> {
            try {
                long from = Long.parseLong(JOptionPane.showInputDialog("From Account:"));
                long to = Long.parseLong(JOptionPane.showInputDialog("To Account:"));
                double amt = Double.parseDouble(JOptionPane.showInputDialog("Amount:"));

                boolean ok = TransactionService.transfer(from, to, amt);

                if (ok)
                    JOptionPane.showMessageDialog(null, "Transfer Successful");
                else
                    JOptionPane.showMessageDialog(null, "Transfer Failed");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        });

        //  HISTORY
        historyBtn.addActionListener(e -> {
            try {
                long acc = Long.parseLong(JOptionPane.showInputDialog("Account ID:"));

                TransactionService.showHistory(acc);

                JOptionPane.showMessageDialog(null, "Check console for history");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        });

        // EXIT
        exitBtn.addActionListener(e -> dispose());

        setVisible(true);
    }
}