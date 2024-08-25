package com.bankingapplication.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    private double balance;
    
    private LocalDate dateofcreate;
    
    @Embedded
    private Address address;
    
    private String email;
    
    private Long mobileNo;
    
    private LocalDate dateofbirth;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<AllTransaction> allTransactions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getDateofcreate() {
		return dateofcreate;
	}

	public void setDateofcreate(LocalDate dateofcreate) {
		this.dateofcreate = dateofcreate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Set<AllTransaction> getAllTransactions() {
		return allTransactions;
	}

	public void setAllTransactions(Set<AllTransaction> allTransactions) {
		this.allTransactions = allTransactions;
	}

	public Account(Long id, String accountHolderName, double balance, LocalDate dateofcreate, Address address,
			String email, Long mobileNo, LocalDate dateofbirth, Set<AllTransaction> allTransactions) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.dateofcreate = dateofcreate;
		this.address = address;
		this.email = email;
		this.mobileNo = mobileNo;
		this.dateofbirth = dateofbirth;
		this.allTransactions = allTransactions;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountHolderName=" + accountHolderName + ", balance=" + balance
				+ ", dateofcreate=" + dateofcreate + ", address=" + address + ", email=" + email + ", mobileNo="
				+ mobileNo + ", dateofbirth=" + dateofbirth + ", allTransactions=" + allTransactions + "]";
	}

	
    
    
	
   
}
