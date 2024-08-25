import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from '../account';

@Component({
  selector: 'app-accounts-details',
  templateUrl: './accounts-details.component.html',
  styleUrls: ['./accounts-details.component.css']
})
export class AccountsDetailsComponent implements OnInit {
  id:number=0;
  account:Account = new Account();
  constructor(private accountservice:AccountService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit()
  {
      this.id=this.route.snapshot.params['id'];
      this.accountservice.getAccountById(this.id).subscribe(data=>{
        console.log(data);
        this.account=data;
      })
  }

}
