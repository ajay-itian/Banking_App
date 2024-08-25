package com.bankingapplication.service.imple;

import com.bankingapplication.dto.AllTransactionDto;
import com.bankingapplication.entity.Account;
import com.bankingapplication.entity.AllTransaction;
import com.bankingapplication.mapper.TransactionMapper;
import com.bankingapplication.repository.TransactionAllRepo;
import com.bankingapplication.service.TransactionService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImple implements TransactionService {

    @Autowired
    private TransactionAllRepo allTransactionRepo;

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public AllTransactionDto CreateTransaction(AllTransactionDto allTransactionDto) {
        if (allTransactionDto == null || allTransactionDto.getAccount() == null) {
            throw new IllegalArgumentException("Invalid transaction or account data");
        }

      
            AllTransaction transaction = transactionMapper.maptoAllTransaction(allTransactionDto);
            allTransactionRepo.save(transaction);
            return TransactionMapper.mAllTransactionDto(transaction);
       
    }

	@Override
	public List<AllTransactionDto> gettAllTransaction() {
		// TODO Auto-generated method stub
		return allTransactionRepo.findAll().stream().
				map(TransactionMapper::mAllTransactionDto)
				.collect(Collectors.toList());
	}
}
