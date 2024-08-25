package com.bankingapplication.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.bankingapplication.entity.Address;
import com.bankingapplication.entity.AllTransaction;

@Component
public class AccountDto {

    private Long id;
    private String accountHolderName;
    private double balance;
   private LocalDate dateofcreate;
    
    private Address address;
    
    private String email;
    
    private Long mobileNo;
    
    private LocalDate dateofbirth;
    
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

	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDto(Long id, String accountHolderName, double balance, LocalDate dateofcreate, Address address,
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

	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", accountHolderName=" + accountHolderName + ", balance=" + balance
				+ ", dateofcreate=" + dateofcreate + ", address=" + address + ", email=" + email + ", mobileNo="
				+ mobileNo + ", dateofbirth=" + dateofbirth + ", allTransactions=" + allTransactions + "]";
	}
  
	
    
    
  
}
