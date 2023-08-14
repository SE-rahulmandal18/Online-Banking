import { Router } from '@angular/router';
import { UserServicesService } from './../service/user-services.service';
import { UpdateserviceService} from './../updateservice.service';
import { Component, OnInit } from '@angular/core';
import{ FormControl,FormGroup,Validators} from '@angular/forms'


@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {


  constructor(public service:UpdateserviceService,private router:Router,private userService:UserServicesService) { }
  savingAccountNumber;
  savingAccountBalance;
  primaryAccountNumber;
  primaryAccountBalance;
  userName = this.userService.getUserName();
  firstnames = sessionStorage.getItem("firstname");
  lastnames = sessionStorage.getItem("lastname");
  phonenumber = sessionStorage.getItem("phonenumber");
  email = sessionStorage.getItem("mailid");
  addresss = sessionStorage.getItem("address");
  password = sessionStorage.getItem("password");
 
  formData:FormGroup = new FormGroup({
    $key:new FormControl(null),
    fullname:new FormControl("",Validators.required),
    surname:new FormControl("",Validators.required),
    mailid:new FormControl("",Validators.required),
    address:new FormControl("",Validators.required),
    phonenumber:new FormControl("",[Validators.required,Validators.minLength(10)]),
    password:new FormControl(""),
    // savings_account_id:new FormControl(""),
    // primary_account_id:new FormControl("")  
  })
  
  ngOnInit(): void {
    console.log(this.firstnames);
    
    this.savingAccountNumber = sessionStorage.getItem("savingAccountNumber");
    this.savingAccountBalance = sessionStorage.getItem("savingAccountBalance");
    this.primaryAccountBalance = sessionStorage.getItem("primaryAccountBalance");
    this.primaryAccountNumber = sessionStorage.getItem("primaryAccountNumber");
  }

  onclear(){
    this.formData.reset();
  }
  updData(){
    console.log("button clicked"+this.formData.value);
   this.service.updDatabackend(this.phonenumber,this.formData.value).subscribe(
    (res:any)=>console.log(res,"Details updated")
    );

    this.router.navigate(['login'])
  }
  
}
