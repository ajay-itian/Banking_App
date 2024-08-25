import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../transaction.service';
import { Router } from '@angular/router';
import { AllTransaction } from '../AllTransaction';

@Component({
  selector: 'app-all-transaction',
  templateUrl: './all-transaction.component.html',
  styleUrls: ['./all-transaction.component.css']
})
export class AllTransactionComponent {




  alltransaction:AllTransaction[]=[];
  constructor(private transactionservice:TransactionService,private router:Router) { }

  ngOnInit()
  {
    this.getAllTransactions();
  }


  getAllTransactions()
  {
      this.transactionservice.getAllTransactions().subscribe(data=>{
        this.alltransaction=data;

        console.log(this.alltransaction);

      })
  }
  

}
