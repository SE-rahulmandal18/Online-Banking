import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoanRequestService {
  [x: string]: any;

  constructor (private http:HttpClient){}

  getLoanRequestList() {
    let url = "http://localhost:8090/allloan";
    return this.http.get(url);
  }

  confirmLoanRequest(id: number) {
    let url = "http://localhost:8090/admin/confirmloantrue/"+id;
    return this.http.get(url);
  }
}
