package com.bankingapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "AllTransactions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_generator")
    @SequenceGenerator(name = "transaction_id_generator", sequenceName = "TX_ID_SEQ", allocationSize = 1)
    private Long transcId;

    private double amount;
    private String action;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

	public AllTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public AllTransaction(Long transcId, double amount, String action, Account account) {
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
		return "AllTransaction [transcId=" + transcId + ", amount=" + amount + ", action=" + action + ", account="
				+ account + "]";
	}

    
   
}
