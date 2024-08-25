import { Injectable } from '@angular/core';
import { AllTransaction } from './AllTransaction';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private baseUrl="http://localhost:8181/api/transactions";

  constructor(private http:HttpClient) { }

    public transaction(alltransact:AllTransaction)
    {
      console.log('generated transaction'+alltransact);
    }


    getAllTransactions():Observable<AllTransaction[]>
    {
        return this.http.get<AllTransaction[]>(`${this.baseUrl}`);
    }
}
