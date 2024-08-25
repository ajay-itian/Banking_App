package com.bankingapplication.dto;

import com.bankingapplication.entity.AllTransaction;

public class WithdrawRequest {
    private double amount;
    private AllTransaction transaction;

    // Getters and Setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public AllTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(AllTransaction transaction) {
        this.transaction = transaction;
    }
}
