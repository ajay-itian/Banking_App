package com.bankingapplication.service;

import java.util.List;

import com.bankingapplication.dto.AllTransactionDto;
import com.bankingapplication.entity.Account;

public interface TransactionService {
	
AllTransactionDto	CreateTransaction(AllTransactionDto allTransactionDto);

List<AllTransactionDto> gettAllTransaction();

}
