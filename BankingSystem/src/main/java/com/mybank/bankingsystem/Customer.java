
package com.mybank.bankingsystem;

public class Customer {
    private String name;
    private String id;
    private String email;
    private BankAccount account;

    public Customer(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public BankAccount getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}

