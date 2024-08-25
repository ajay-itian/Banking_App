import { Component, OnInit } from '@angular/core';
import { Account } from '../account';
import { AccountService } from '../account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AllTransaction } from '../AllTransaction';
import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {

 
  id:number=0;
  account:Account=new Account();
 

  constructor(private accountService:AccountService,private route:ActivatedRoute,private router:Router
    ,private transactionService:TransactionService
  ) { }

  ngOnInit() 
  {

    this.id=this.route.snapshot.params['id'];
    this.accountService.getAccountById(this.id).subscribe(data=>{
        this.account=data;
    })

  }

  successMessage="";
  errorMessage="";

  onSubmit() {

    const transaction = new AllTransaction();
    transaction.action="deposit";
    transaction.amount=this.account.balance;
    transaction.account=this.account;

    if(this.isvalidAmount(this.account.balance))
      {
        this.accountService.deposit(this.id,this.account.balance,transaction).subscribe(data=>{
          this.account=data;
          this.successMessage="Deposit Succesfully";
          this.transactionService.transaction(transaction);
          setTimeout(()=>{
            this.router.navigate(['/accounts']);
          },1000)
        
         
          
        })

      }
      else
      {

        this.errorMessage="Invalid Amount Please enter valid amount";
        setTimeout(()=>{
         this.errorMessage="";
        },1000)
        
      }
      
  }

    isvalidAmount(amount:number):boolean
    {
      return amount > 0 && amount<10000000;
    }



}
