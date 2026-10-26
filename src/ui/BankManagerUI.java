package ui;

import javax.swing.*;
import java.awt.*;

import enums.EnumAccountType;
import service.AccountService;
import service.CustomerService;

public class BankManagerUI extends JFrame {

    public BankManagerUI() {

        setTitle("Bank Manager");
        setSize(450,500);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("MANAGER PANEL");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(100,20,300,30);
        add(title);

        JButton add = new JButton("Add Customer");
        add.setBounds(120,80,200,35);
        add(add);

        JButton show = new JButton("Show Customers");
        show.setBounds(120,130,200,35);
        add(show);

        JButton update = new JButton("Update Customer");
        update.setBounds(120,180,200,35);
        add(update);

        JButton delete = new JButton("Delete Customer");
        delete.setBounds(120,230,200,35);
        add(delete);

        JButton createAcc = new JButton("Create Account");
        createAcc.setBounds(120,280,200,35);
        add(createAcc);

        JButton exit = new JButton("Exit");
        exit.setBounds(120,340,200,35);
        add(exit);

        //  ACTIONS

        add.addActionListener(e -> {
            int nip = Integer.parseInt(JOptionPane.showInputDialog("NIP:"));
            String f = JOptionPane.showInputDialog("First name:");
            String l = JOptionPane.showInputDialog("Last name:");
            String email = JOptionPane.showInputDialog("Email:");
            String phone = JOptionPane.showInputDialog("Phone:");

            CustomerService.createCustomer(nip,f,l,email,phone);

            JOptionPane.showMessageDialog(null,"Customer added");
        });

        show.addActionListener(e -> CustomerService.showCustomers());

        update.addActionListener(e -> {
            long id = Long.parseLong(JOptionPane.showInputDialog("Customer ID:"));
            int nip = Integer.parseInt(JOptionPane.showInputDialog("New NIP:"));
            String f = JOptionPane.showInputDialog("First name:");
            String l = JOptionPane.showInputDialog("Last name:");
            String email = JOptionPane.showInputDialog("Email:");
            String phone = JOptionPane.showInputDialog("Phone:");

            CustomerService.updateCustomer(id,nip,f,l,email,phone);

            JOptionPane.showMessageDialog(null,"Updated");
        });

        delete.addActionListener(e -> {
            long id = Long.parseLong(JOptionPane.showInputDialog("Customer ID:"));
            CustomerService.deleteCustomer(id);

            JOptionPane.showMessageDialog(null,"Deleted");
        });

        createAcc.addActionListener(e -> {
            int nip = Integer.parseInt(JOptionPane.showInputDialog("Customer NIP:"));
            double bal = Double.parseDouble(JOptionPane.showInputDialog("Balance:"));

            AccountService.createAccount(nip,bal,EnumAccountType.CHEQUING);

            JOptionPane.showMessageDialog(null,"Account created");
        });

        exit.addActionListener(e -> dispose());

        setVisible(true);
    }
}