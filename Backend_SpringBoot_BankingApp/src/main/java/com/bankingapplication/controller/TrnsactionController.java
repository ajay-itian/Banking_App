package com.bankingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapplication.dto.AllTransactionDto;
import com.bankingapplication.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
@Validated
public class TrnsactionController 
{
	@Autowired
	private  TransactionService transactionService;
	
	





	@GetMapping
	public ResponseEntity<List<AllTransactionDto>> getAllTransaction()
	{
		List<AllTransactionDto> allTransactionDtos=transactionService.gettAllTransaction();
		
		return ResponseEntity.ok(allTransactionDtos);
	}

}
