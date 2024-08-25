import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountListComponent } from './account-list/account-list.component';
import {HttpClientModule} from '@angular/common/http';
import { CreateAccountComponent } from './create-account/create-account.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { AccountsDetailsComponent } from './accounts-details/accounts-details.component';
import { LoginComponent } from './login/login.component';
import { AllTransactionComponent } from './all-transaction/all-transaction.component';
import { CreditPipe } from './credit.pipe';
import { DebitPipe } from './debit.pipe';


@NgModule({
  declarations: [
    AppComponent,
    AccountListComponent,
    CreateAccountComponent,
    DepositComponent,
    WithdrawComponent,
    AccountsDetailsComponent,
    LoginComponent,
    AllTransactionComponent,
    CreditPipe,
    DebitPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
