package com.bankingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapplication.entity.AllTransaction;

public interface TransactionAllRepo extends JpaRepository<AllTransaction, Long>{
	
	

}
