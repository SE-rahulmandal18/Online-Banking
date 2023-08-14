import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormGroup,FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { visitValue } from '@angular/compiler/src/util';
import { User } from '../registration/subComponents/user-registration/user-registration.component';
import { UserServicesService } from '../service/user-services.service';

export class Loan {
  constructor(private accepted:boolean,private user:User){}
}
@Component({
  selector: 'app-loan-request',
  templateUrl: './loan-request.component.html',
  styleUrls: ['./loan-request.component.css']
})
export class LoanRequestComponent implements OnInit {
  [x: string]: any;
  constructor(private route:Router,
    private formbuilder:FormBuilder,
    private service:UserServicesService) { }
 loanRequestForm:FormGroup;  
  account= this.getAccountPassedByParent();

  ngOnInit(): void {
    this.loanRequestForm = this.formbuilder.group({
      accountType:[this.account,[Validators.required]]
    })
  }
  getAccountPassedByParent(){
    return  history.state.data;
  }

  get f(){
    return this.loanRequestForm.controls;
  }
  handleLoanRequest(){
    let userObj = JSON.parse(sessionStorage.getItem("userObj"));
    this.service.requestLoan(new Loan(true,userObj),userObj).subscribe(
      response =>{ 
        alert("Loan request submiited")
        console.log(response
          )
          this.route.navigate(["user","home"]);
        },
      error => { 
        alert("Loan request failed")
        console.log(error)},
    )
  }


  

}