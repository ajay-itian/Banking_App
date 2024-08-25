package com.bankingapplication.mapper;

import org.springframework.stereotype.Component;

import com.bankingapplication.dto.AccountDto;
import com.bankingapplication.dto.AllTransactionDto;
import com.bankingapplication.entity.Account;
import com.bankingapplication.entity.AllTransaction;

@Component
public class TransactionMapper {
	
	  public AllTransaction maptoAllTransaction(AllTransactionDto allTransactionDto) {
	        return new AllTransaction(
	            allTransactionDto.getTranscId(),
	            allTransactionDto.getAmount(),
	            allTransactionDto.getAction(),
	            allTransactionDto.getAccount()
	        );
	    }

	
	
	
	public static AllTransactionDto  mAllTransactionDto(AllTransaction transaction) 
	{
		AllTransactionDto allTransactionDto=new AllTransactionDto(
				
				transaction.getTranscId(),
				transaction.getAmount(),
				transaction.getAction(),
				transaction.getAccount()
				
				);
		
		return allTransactionDto;
	}
	
	
}
