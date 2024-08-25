import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {
private loggedin=false;
  constructor() { }


  isLoggedIn(): boolean {
    return this.loggedin;
  }

  login()
  {
    this.loggedin=true;
  }

  logout()
  {
    this.loggedin=false;

  }
}
