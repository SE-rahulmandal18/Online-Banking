import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';
import { ActivatedRoute, Params } from '@angular/router';
import { HttpClient } from '@angular/common/http';

export class Svaings{
	transactionId:string;
	accNo:number;
	date:Date;
	transactionType:string;
	newBalance:number
}
@Component({
  selector: 'app-savings-transaction',
  templateUrl: './savings-transaction.component.html',
  styleUrls: ['./savings-transaction.component.css']
})
export class SavingsTransactionComponent implements OnInit {

	accNo:number;
	data:number;
	savingsTransactionList: Object[];

	constructor(private route: ActivatedRoute,public http:HttpClient,private userService: UserService) {
		
		this.data=this.userService.getData();
		this.getSavingsTransactionList(this.data);

	}

	getSavingsTransactionList(datum:number) {
		console.log(this.data);
		
		this.userService.getSavingsTransaction(datum).subscribe(
			response =>{
				console.log(response);
				this.savingsTransactionList = JSON.parse(JSON.stringify(response));
			}
		)
	}
	
	ngOnInit() {}
}
