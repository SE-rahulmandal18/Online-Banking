import { User } from './../registration/subComponents/user-registration/user-registration.component';
import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { UserServicesService } from '../service/user-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private service:UserServicesService,public router:Router) { }
  savingAccountNumber;
  savingAccountBalance;
  primaryAccountNumber;
  primaryAccountBalance;
  userName = this.service.getUserName();
  firstname = sessionStorage.getItem("firstname");
  lastname = sessionStorage.getItem("lastname");
  phonenumber = sessionStorage.getItem("phonenumber");
  email = sessionStorage.getItem("mailid");
  address = sessionStorage.getItem("address");
  ngOnInit(): void {
    this.savingAccountNumber = sessionStorage.getItem("savingAccountNumber");
    this.savingAccountBalance = sessionStorage.getItem("savingAccountBalance");
    this.primaryAccountBalance = sessionStorage.getItem("primaryAccountBalance");
    this.primaryAccountNumber = sessionStorage.getItem("primaryAccountNumber");
  }

  editprofile(){
    this.router.navigate["updateuser"];
    // if(confirm("Are you sure want to edit profile")){
    //   this.router.navigate[("updateuser")];
    // //  this.service.updateUserprofile(User).subscribe({

    // //  })
    // }
    // else{
    //   console.log("not yet");
      
    // }
  }
}
