import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountListComponent } from './account-list/account-list.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { AccountsDetailsComponent } from './accounts-details/accounts-details.component';
import { LoginComponent } from './login/login.component';
import { AllTransactionComponent } from './all-transaction/all-transaction.component';

const routes: Routes = [


  {path:'accounts',component:AccountListComponent},
  {path:'login',component:LoginComponent},
  {path:'create-account',component:CreateAccountComponent},
  {path:'deposit/:id',component:DepositComponent},
  {path:'',redirectTo:'login',pathMatch:'full'},
  {path:'withdraw/:id',component:WithdrawComponent},
  {path:'accounts-details/:id',component:AccountsDetailsComponent},
  {path:'alltransaction',component:AllTransactionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
