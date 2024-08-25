package com.bankingapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bankingapplication.dto.AccountDto;
import com.bankingapplication.dto.AllTransactionDto;
import com.bankingapplication.dto.LoginDto;
import com.bankingapplication.dto.WithdrawRequest;
import com.bankingapplication.entity.AllTransaction;
import com.bankingapplication.mapper.TransactionMapper;
import com.bankingapplication.service.AccountService;
import com.bankingapplication.service.TransactionService;
import com.bankingapplication.service.imple.TransactionServiceImple;

@RestController
@RequestMapping("/api/accounts")
@Validated
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    
    @Autowired
    private TransactionService transactionService;

  

@CrossOrigin(origins = "http://localhost:3000")
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto)
    {
    		boolean status=accountService.login(loginDto.getUsername(), loginDto.getPassword());
    		if(status)
    		{
    			return ResponseEntity.ok(status);
    		}
    		else 
    		{
    				return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
				
			}
    }
    
    
    @PostMapping()
    public ResponseEntity<?> addacccount( @ModelAttribute AccountDto accountDto) {
        try {
            AccountDto createdAccount = accountService.createAccount(accountDto);
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody WithdrawRequest request) {
        AccountDto accountDto = accountService.deposit(id, request.getAmount());
        
        System.out.println("deposit invoked");
        AllTransaction allTransaction=request.getTransaction();
        transactionService.CreateTransaction(TransactionMapper.mAllTransactionDto(allTransaction));
  
        return ResponseEntity.ok(accountDto);
    }
    
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody WithdrawRequest request) {
        AccountDto accountDto = accountService.withdraw(id, request.getAmount());
        
        AllTransaction allTransaction = request.getTransaction();
        transactionService.CreateTransaction(TransactionMapper.mAllTransactionDto(allTransaction));

        return ResponseEntity.ok(accountDto);
    }


    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accountDtos = accountService.getAllAccount();
        return ResponseEntity.ok(accountDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "account deleted successfully " + id);
        return ResponseEntity.ok(response);
    }
    
  
    

    

}
