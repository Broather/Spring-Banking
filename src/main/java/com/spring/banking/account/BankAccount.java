package com.spring.banking.account;

import jakarta.persistence.*;

/**
 * a bank account class that stores information about how much money it contains
 */
@Entity
@Table
public class BankAccount {
    @Id
    @SequenceGenerator(name = "account-sequence",
            sequenceName = "account-sequence",
            initialValue = 1000,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "account-sequence")
    private Long accountNumber;
    private float balance;

    public BankAccount() {}

    public BankAccount(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("%d", this.accountNumber);
    }

    public Long getAccountNumber() {
        return this.accountNumber;
    }

    public float getBalance() {
        return this.balance;
    }

    public void deposit(float amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Given amount must be positive or 0");
        }
        this.balance += amount;
    }

    public void withdraw(float amount) throws IllegalArgumentException, IllegalStateException {
        if (amount < 0) {
            throw new IllegalArgumentException("Given amount must be positive or 0");
        } else if (amount > this.balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        this.balance -= amount;
    }

    public void printBalance() {
        System.out.println(this.balance);
    }

    public void transferAmount(float amount, BankAccount other) throws IllegalArgumentException, IllegalStateException {
        this.withdraw(amount);
        other.deposit(amount);
    }

}