import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

export class Savings{
	constructor(transactionId:string,
	accNo:number,
	date:Date,
	transactionType:string,
	newBalance:number){}
}

@Injectable()
export class UserService {

  constructor (private http:HttpClient){}

  public data:any;

  setData(data){
    this.data = data;
  }

  getData(){
    let temp = this.data;
    //this.clearData();
    return temp;
  }

  // clearData(){
  //   this.data = undefined;
  // }
  
  getUsers() {
    let url = "http://localhost:8090/admin/getallusers";
    return this.http.get(url);
  }

   getPrimaryTransactionList(userAcc:number) {
     let url = `http://localhost:8090/admin/accounts/${userAcc}/transactions`;
    return this.http.get(url);
   }

   getSavingsTransactionList(userAcc:number) {
    console.log("hello");
     let url = "http://localhost:8090/admin/accounts/"+userAcc+"/transactions";
    return this.http.get(url);
   }
   getSavingsTransaction(accno:number) {
    console.log("hello");
    let url = "http://localhost:8090/admin/accounts/"+accno+"/transactions";
   return this.http.get(url);
  }
   enableUser (username: string) {
     let url = "http://localhost:8090/api/user/"+username+"/enable";
     return this.http.get(url, { withCredentials: true });
   }

   disableUser (username:number) {
     let url = "http://localhost:8090/admin/admin/deleteuser/"+username;
     return this.http.delete(url);
   }

}
