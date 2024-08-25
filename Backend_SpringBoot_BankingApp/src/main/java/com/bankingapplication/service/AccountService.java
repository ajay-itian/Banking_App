package com.bankingapplication.service;

import com.bankingapplication.dto.AccountDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccount();

    void deleteAccount(Long id);
    
    boolean login(String username,String password);
}
