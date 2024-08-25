import { Component, OnInit } from '@angular/core';
import { Account } from '../account';
import { AccountService } from '../account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TransactionService } from '../transaction.service';
import { AllTransaction } from '../AllTransaction';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit {

  id: number = 0;
  account = new Account();
  successMessage = "";
  errorMessage = "";

  constructor(
    private accountservice: AccountService,
    private transactionService: TransactionService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.accountservice.getAccountById(this.id).subscribe((data) => {
      this.account = data;
    });
  }

  onSubmit() {
    if (this.isvalidAmount(this.account.balance)) {
      const transaction = new AllTransaction();
      transaction.action = 'withdraw';
      transaction.amount = this.account.balance; // Correctly set the amount property
      transaction.account = this.account;

      this.accountservice.withdraw(this.id, this.account.balance,transaction).subscribe((data) => {
        this.account = data;
        this.successMessage = "Amount Withdrawn Successfully";

        // Log the transaction
        this.transactionService.transaction(transaction);

        setTimeout(() => {
          this.router.navigate(['/accounts']);
        }, 1000);
      });
    } else if (this.account.balance > 1000000) {
      this.errorMessage = "Please enter amount below 10 Lakhs";

      setTimeout(() => {
        this.errorMessage = "";
      }, 1000);
    } else {
      this.errorMessage = "Please enter a valid amount";

      setTimeout(() => {
        this.errorMessage = "";
      }, 1000);
    }
  }

  isvalidAmount(amount: number): boolean {
    return amount > 0 && amount < 10000000;
  }
}
