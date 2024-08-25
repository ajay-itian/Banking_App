package com.bankingapplication.mapper;

import java.time.LocalDate;

import com.bankingapplication.dto.AccountDto;
import com.bankingapplication.entity.Account;

public class AccountMapper {
	
	public static Account  mapToAccount(AccountDto accountDto) 
	{
		Account account=new Account(
				
				accountDto.getId(),
				
				accountDto.getAccountHolderName(),
				
				accountDto.getBalance(),
				accountDto.getDateofcreate(),
				
				accountDto.getAddress(),
				accountDto.getEmail(),
				accountDto.getMobileNo(),
				accountDto.getDateofbirth(),
				accountDto.getAllTransactions()
				
				);
		
		return account;
	}
	
	
	
	public static AccountDto  mapToAccountDto(Account account) 
	{
		AccountDto accountDto=new AccountDto(
				
				account.getId(),
				
				account.getAccountHolderName(),
				
				account.getBalance(),
				
				account.getDateofcreate(),
				account.getAddress(),
				account.getEmail(),
				account.getMobileNo(),
				account.getDateofbirth(),
				account.getAllTransactions()
				
				);
		
		return accountDto;
	}
}
