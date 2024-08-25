import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { AccountService } from '../account.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthserviceService } from '../authservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  loginForm!:FormGroup;





  constructor(private route:Router,private service:AccountService,private fb:FormBuilder,private authservice:AuthserviceService) { }

  ngOnInit(): void {

    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
    
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }
    const { username, password } = this.loginForm.value;
   
  
    this.service.login(username,password).subscribe(res=>{
          console.log(res);
                
          if(res)
            {
              this.authservice.login();
              this.route.navigate(['/accounts']);
            }
            else
            {
              alert('Login Failed');
            }
    });

  }

 
  
}
