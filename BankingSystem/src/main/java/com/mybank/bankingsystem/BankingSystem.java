package com.mybank.bankingsystem;

import javax.swing.*;
import java.awt.*;

public class BankingSystem extends JFrame {
    private Customer customer;
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JPanel transactionPanel;
    
    public BankingSystem() {
        // Set up the frame
        setTitle("Banking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        
        // Create main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Customer Registration Panel
        JPanel registrationPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        registrationPanel.setBorder(BorderFactory.createTitledBorder("Customer Registration"));
        
        JTextField nameField = new JTextField();
        JTextField idField = new JTextField();
        JTextField emailField = new JTextField();
        
        registrationPanel.add(new JLabel("Name:"));
        registrationPanel.add(nameField);
        registrationPanel.add(new JLabel("ID:"));
        registrationPanel.add(idField);
        registrationPanel.add(new JLabel("Email:"));
        registrationPanel.add(emailField);
        
        JButton registerButton = new JButton("Register");
        registrationPanel.add(registerButton);
        
        // Transaction Panel
        transactionPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        transactionPanel.setBorder(BorderFactory.createTitledBorder("Transactions"));
        
        balanceLabel = new JLabel("Balance: $0.00");
        amountField = new JTextField();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        
        transactionPanel.add(balanceLabel);
        transactionPanel.add(new JLabel("Amount:"));
        transactionPanel.add(amountField);
        transactionPanel.add(depositButton);
        transactionPanel.add(withdrawButton);
        
        // Add panels to main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(registrationPanel, gbc);
        
        gbc.gridy = 1;
        mainPanel.add(transactionPanel, gbc);
        
        // Initially disable transaction panel
        enableTransactionPanel(false);
        
        // Add main panel to frame
        add(mainPanel);
        
        // Register Button Action
        registerButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String id = idField.getText().trim();
            String email = emailField.getText().trim();
            
            if (name.isEmpty() || id.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Please fill in all fields", 
                    "Registration Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            customer = new Customer(name, id, email);
            account = new BankAccount("ACC" + System.currentTimeMillis(), customer);
            
            enableTransactionPanel(true);
            updateBalance();
            
            // Disable registration panel
            nameField.setEnabled(false);
            idField.setEnabled(false);
            emailField.setEnabled(false);
            registerButton.setEnabled(false);
            
            JOptionPane.showMessageDialog(this, 
                "Account created successfully!\nAccount Number: " + account.getAccountNumber(), 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
        });
        
        // Deposit Button Action
        depositButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                updateBalance();
                amountField.setText("");
                JOptionPane.showMessageDialog(this, 
                    "Deposit successful!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Please enter a valid amount", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, 
                    ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Withdraw Button Action
        withdrawButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                account.withdraw(amount);
                updateBalance();
                amountField.setText("");
                JOptionPane.showMessageDialog(this, 
                    "Withdrawal successful!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Please enter a valid amount", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, 
                    ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void enableTransactionPanel(boolean enable) {
        for (Component component : transactionPanel.getComponents()) {
            component.setEnabled(enable);
        }
    }
    
    private void updateBalance() {
        balanceLabel.setText(String.format("Balance: $%.2f", account.getBalance()));
    }
    
    public static void main(String[] args) {
        // Set Look and Feel to system default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new BankingSystem().setVisible(true);
        });
    }
}