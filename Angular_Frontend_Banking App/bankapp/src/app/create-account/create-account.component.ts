import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { Account } from '../account';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Address } from '../Address';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.scss']
})
export class CreateAccountComponent implements OnInit {

  accountCreate = false;
  postaccount!: FormGroup;
  selectedFile: File | null = null;
  account: Account = new Account();

  constructor(private accountService: AccountService, private router: Router, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.postaccount = this.fb.group({
      accountHolderName: [null, Validators.required],
      balance: [null, Validators.required],
      mobileNo: [null, Validators.required],
      email: [null, Validators.required],
      dateofbirth: [null, Validators.required],
      houseName: [null, Validators.required],
      streetName: [null, Validators.required],
      Area: [null, Validators.required],
      City: [null, Validators.required],
      District: [null, Validators.required],
      State: [null, Validators.required],
      Country: [null, Validators.required],
      pincode: [null, Validators.required],
      dateofcreate: [null, Validators.required]
    });
  }

  onSubmit() {
    if (!this.postaccount.get('dateofcreate')?.value) {
      this.postaccount.get('dateofcreate')?.setValue(new Date());
    }
    this.createAccount();
  }

  createAccount() {
    const formData = new FormData();

    formData.append('accountHolderName', this.postaccount.get('accountHolderName')?.value);
    formData.append('balance', this.postaccount.get('balance')?.value);
    formData.append('mobileNo', this.postaccount.get('mobileNo')?.value);
    formData.append('houseName', this.postaccount.get('houseName')?.value);
    formData.append('streetName', this.postaccount.get('streetName')?.value);
    formData.append('area', this.postaccount.get('area')?.value);
    formData.append('city', this.postaccount.get('city')?.value);
    formData.append('district', this.postaccount.get('district')?.value);
    formData.append('state', this.postaccount.get('state')?.value);
    formData.append('country', this.postaccount.get('country')?.value);
    formData.append('pincode', this.postaccount.get('pincode')?.value);
    formData.append('email', this.postaccount.get('email')?.value);
    formData.append('dateofbirth', this.postaccount.get('dateofbirth')?.value);

    const dateofcreate = this.postaccount.get('dateofcreate')?.value ? 
                         this.postaccount.get('dateofcreate')?.value.toISOString().split('T')[0] : 
                         new Date().toISOString().split('T')[0];
    formData.append('dateofcreate', dateofcreate);

    const address: Address = this.postaccount.value;
    formData.append('address.houseName', address.houseName);
    formData.append('address.streetName', address.streetName);
    formData.append('address.Area', address.area);
    formData.append('address.City', address.city);
    formData.append('address.District', address.district);
    formData.append('address.State', address.state);
    formData.append('address.Country', address.country);
    formData.append('address.pincode', address.pincode.toString());

    this.accountService.createAccount(formData).subscribe((res) => {
      console.log(res);
      this.account = res;
      this.accountCreate = true;
      setTimeout(() => {
        this.gotoAccountList();
      }, 2000);
    }, error => {
      console.error('Error creating account', error);
    });
  }

  gotoAccountList() {
    this.router.navigate(['/accounts']);
  }
}
