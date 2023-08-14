import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-primary-transaction',
  templateUrl: './primary-transaction.component.html',
  styleUrls: ['./primary-transaction.component.css']
})
export class PrimaryTransactionComponent implements OnInit {

	userList:object[];
    userAcc:number;
	primaryTransactionList: Object[];

	constructor(private route: ActivatedRoute, private userService: UserService) {
        this.userAcc=this.userService.getData();
		this.getPrimaryTransactionList(this.userAcc);
	}

	getUsers() {
		this.userService.getUsers().subscribe(
			res => {
			console.log(res);
            this.userList = JSON.parse(JSON.stringify(res));
      		},
      		error => console.log(error)
		)
	}
	
	getPrimaryTransactionList(data:number) {
		this.userService.getPrimaryTransactionList(data).subscribe(
			response =>{
				console.log(response);
				this.primaryTransactionList = JSON.parse(JSON.stringify(response));
			}
		)
	}

	ngOnInit() {}

}
