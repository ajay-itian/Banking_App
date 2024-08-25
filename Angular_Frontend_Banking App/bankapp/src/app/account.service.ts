import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Account } from './account';
import { AllTransaction } from './AllTransaction';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  
  private baseUrl = 'http://localhost:8181/api/accounts';
  
  constructor(private http: HttpClient) { }

  getAllAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(`${this.baseUrl}`);
  }

  createAccount(account: any): Observable<Account> {
    return this.http.post<Account>(`${this.baseUrl}`, account, {
        headers: {
            'enctype': 'multipart/form-data'
        }
    }).pipe(
        catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    // Handle the error here
    return throwError('An error occurred while creating the account.');
  }

  getAccountById(id: number): Observable<Account> {
    return this.http.get<Account>(`${this.baseUrl}/${id}`);
  }

 

  login(username: string, password: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/login`, { username, password });
  }

  withdraw(id: number, amount: number, transaction: AllTransaction): Observable<Account> {
    const request = { amount,transaction };
    return this.http.put<Account>(`${this.baseUrl}/${id}/withdraw`, request);
  }


  deposit(id: number, amount: number,transaction:AllTransaction): Observable<Account> {
    const request = { amount ,transaction};
    return this.http.put<Account>(`${this.baseUrl}/${id}/deposit`, request);
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/${id}`);
  }
}
