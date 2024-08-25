package com.bankingapplication.dto;

import com.bankingapplication.entity.Account;

public class AllTransactionDto {

    private Long transcId;
    private double amount;
    private String action;
    private Account account;
	public AllTransactionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllTransactionDto(Long transcId, double amount, String action, Account account) {
		super();
		this.transcId = transcId;
		this.amount = amount;
		this.action = action;
		this.account = account;
	}
	
	
	
	public Long getTranscId() {
		return transcId;
	}
	public void setTranscId(Long transcId) {
		this.transcId = transcId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "AllTransactionDto [transcId=" + transcId + ", amount=" + amount + ", action=" + action + ", account="
				+ account + "]";
	}

    
    
    
}
  
