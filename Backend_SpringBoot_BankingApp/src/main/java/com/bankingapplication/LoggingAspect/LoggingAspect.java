package com.bankingapplication.LoggingAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.bankingapplication.dto.AccountDto;
import com.bankingapplication.dto.WithdrawRequest;
import com.bankingapplication.entity.Account;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@ToString
public class LoggingAspect 
{
	@Pointcut("execution(* com.bankingapplication.service.AccountService.login(String, String))")
	public void loginPointCut() {}
	
	

	@Pointcut("execution(* com.bankingapplication.service.AccountService.createAccount(com.bankingapplication.dto.AccountDto))")
	public void AccountCreationpointcut() {}
	
	
	
	@Before("loginPointCut()")
	public void beforeLogin(JoinPoint joinPoint) {
	    Object[] args = joinPoint.getArgs();
	    String username = (String) args[0];
	    String password = (String) args[1];
	    log.info("Attempting login with username: {} and password: {}", username, password);
	}

	@After("loginPointCut()")
	public void afterLogin(JoinPoint joinPoint) {
	    Object[] args = joinPoint.getArgs();
	    String username = (String) args[0];
	    String password = (String) args[1];
	    log.info("Login with username: {} and password: {} is valid", username, password);
	}
	
		
	
	@Before("AccountCreationpointcut()")
	public void beforeAccountCreation(JoinPoint joinPoint)
	{
		Object[]  args=joinPoint.getArgs();
		for(Object arg: args)
		{
			if(arg instanceof AccountDto)
			{
				AccountDto accountDto=(AccountDto)arg;
				
				log.info("Going for account creation {}",accountDto);
			}
		}
		
	}

	@After("AccountCreationpointcut()")
	public void AfterAccountCreation(JoinPoint joinPoint)
	{
		
		Object[] args=joinPoint.getArgs();
		
		for(Object arg:args)
		{
			if(arg instanceof AccountDto)
			{
					AccountDto accountDto=(AccountDto)arg;
					
					log.info("Account Created Succefully {}",accountDto);
			}
		}
	}
	
	

    @Pointcut("execution(* com.bankingapplication.controller.AccountController.deposit(Long,com.bankingapplication.dto.WithdrawRequest))")
    public void Depositpointcut() {}

    @After("Depositpointcut()")
    public void AfterDepositAccount(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Long accountid = (Long) args[0]; 
        
       
      WithdrawRequest withdrawRequest=(WithdrawRequest) args[1];
      
      Account account = withdrawRequest.getTransaction().getAccount();
      
      if(withdrawRequest.getAmount() <= 0)
      {
    	  log.error("You have entered invalid amount"+withdrawRequest.getAmount());
    	  
    	  
      }
      else if(accountid.equals(account.getId()))
      {
          String accountHolderName = (account.getAccountHolderName() != null) ? account.getAccountHolderName() : "Unknown";
          log.info("Deposit processed successfully for account id: {} with request : Amount={},TransactionType={} Account Holder Name = {}", accountid, withdrawRequest.getAmount(),withdrawRequest.getTransaction().getAction(),
        		  accountHolderName);

      }
     

    }
    
    
    @Pointcut("execution(* com.bankingapplication.controller.AccountController.withdraw(Long,com.bankingapplication.dto.WithdrawRequest))")
    public void Withdrawpointcut() {}
    
    @After("Withdrawpointcut()")
    public void  AfterCreditAccount(JoinPoint joinPoint)
    {
    	Object[] args=joinPoint.getArgs();
    	Long accountid=(Long) args[0];
    	
    	WithdrawRequest withdrawRequest=(WithdrawRequest)args[1];
    	
    	   Account account = withdrawRequest.getTransaction().getAccount();
    	   
    	   if(withdrawRequest.getAmount() <= 0)
    	      {
    	    	  log.error("You have entered invalid amount"+withdrawRequest.getAmount());
    	    	  
    	    	  
    	      }
    	      
    	   		else if(accountid.equals(account.getId()))
    	      {
    	          String accountHolderName = (account.getAccountHolderName() != null) ? account.getAccountHolderName() : "Unknown";
    	          log.info("Withdraw processed successfully for account id: {} with request : Amount={},TransactionType={} Account Holder Name = {}", accountid, withdrawRequest.getAmount(),withdrawRequest.getTransaction().getAction(),
    	        		  accountHolderName);

    	      }
    }
 }

	

