import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { PrimaryTransactionComponent } from '../primary-transaction/primary-transaction.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
	[x: string]: any;

	userList: Object[];
	userAcc:number;
    loggedIn: boolean;

	constructor(private loginService: LoginService,public http:HttpClient, private router : Router,private userService: UserService) {
		if(localStorage.getItem('PortalAdminHasLoggedIn') == '') {
			this.loggedIn = false;
		} else {
			this.loggedIn = true;
		}

		this.getUsers();
	}

	logout(){
		this.loggedIn=false;
		localStorage.clear();
		localStorage.setItem('PortalAdminHasLoggedIn', '');
		this.router.navigate(['/login']);
	}

	getDisplay() {
    if(!this.loggedIn){
      return "none";
    } else {
      return "";
    }
  }

	getUsers() {
		this.userService.getUsers().subscribe(
			res => {
            this.userList = JSON.parse(JSON.stringify(res));
      		},
      		error => console.log(error)
		)
	}
	onSelectPrimary(userAcc: any) {
    	this.router.navigate(['/primaryTransaction', userAcc]);
		this.userService.setData(userAcc);
  	}	

  	onSelectSavings(userAcc: any) {
    	this.router.navigate(['/savingsTransaction', userAcc]);
		this.userService.setData(userAcc);
  	}	
	
  ngOnInit() {
  }

}
