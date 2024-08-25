package com.bankingapplication.service.imple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bankingapplication.dto.AccountDto;
import com.bankingapplication.entity.Account;
import com.bankingapplication.exception.AccountNotFoundException;
import com.bankingapplication.exception.InsufficientBalanceException;
import com.bankingapplication.mapper.AccountMapper;
import com.bankingapplication.repository.AccountRepo;
import com.bankingapplication.service.AccountService;
import com.bankingapplication.utility.IdGenerator;

@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;

     
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        account.setId(IdGenerator.generate12DigitId());
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setBalance(accountDto.getBalance());
        account.setDateofcreate(LocalDate.now());
        account.setAddress(accountDto.getAddress());
        account.setDateofbirth(accountDto.getDateofbirth());
        account.setEmail(accountDto.getEmail());
        account.setMobileNo(accountDto.getMobileNo());
        account.setAllTransactions(accountDto.getAllTransactions());
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }



    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        account.setBalance(account.getBalance() + amount);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        account.setBalance(account.getBalance() - amount);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        return accountRepo.findAll().stream()
                .map(AccountMapper::mapToAccountDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
        accountRepo.delete(account);
    }

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stu
		if(username.equals("bank@abc.com")&&password.equals("bankabc"))
		{
			System.out.println("invoked login");
			return true;
		}
		return false;
	}
}
