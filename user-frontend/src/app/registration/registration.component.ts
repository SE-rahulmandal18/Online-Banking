import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgModule } from '@angular/compiler/src/core';
import {FormsModule,FormGroup,FormControl,FormBuilder, Validators} from '@angular/forms';
//import {FormGroup,FormControl,Validators,FormBuilder, Form}  from "@angular/forms"
import { UserServicesService } from 'src/app/service/user-services.service';
import { Md5 } from 'ts-md5';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private router : Router, private formbuilder:FormBuilder ) { }
  invalidAddressLine1:boolean=false;
  invalidAddressLine2:boolean=false;
  invalidAddressLine3:boolean=false;
  invalidAddressLine4:boolean=false;
  invalidAddressLine5:boolean=false;
  addressLine1:string="";
  addressLine2:string="";
  addressLine3:string="";
  addressLine4:string="";
  addressLine5:string="";
  fullAddress:string;

  addressArray:String[]
  invalidAddressArray:boolean[]

  areAllFieldsValid = true;
  firstName:string;
  lastName:string;
  invalidFirstName = false;
  invalidLasttName = false;
  contactForm : FormGroup;
  submitted = false;
  age:number;
  kycForm:FormGroup;
  invalidPan:any;
  invalidAge = false;
  ngOnInit(): void {
    this.contactForm = this.formbuilder.group({
      email : ["",[Validators.required,Validators.email]],
      phone: ["", [Validators.required, Validators.minLength(10),Validators.pattern(/^-?(0|[1-9]\d*)?$/)]],
    })
    this.kycForm = this.formbuilder.group({
      pan : ["",[Validators.required]],
      dob : ["",[Validators.required]]    
    })
  
  }


 

  validateContactDetails(){
    
    if(this.contactForm.valid )
    {   sessionStorage.setItem("phonenumber",this.contactForm.get("phone").value);
        sessionStorage.setItem("mailid",this.contactForm.get("email").value);
        //this.router.navigate(["register","kycDetails"]);
        console.log("hello")
     }
     if(this.firstName===undefined ){
      this.invalidFirstName = true;
      
    }
    if(this.lastName===undefined){
      this.invalidLasttName = true;
    }
    
    else {
    sessionStorage.setItem("firstName",this.firstName);
    sessionStorage.setItem("lastName",this.lastName);
    
    }
    console.log(this.kycForm.get("dob").value);
    let currentDate:any =  new Date(this.kycForm.get("dob").value);
    let timeDiff =  Math.abs(Date.now() - currentDate)
    this.age = Math.floor((timeDiff / (1000 * 3600 * 24))/365);
    console.log(this.age);
    if(this.age<10){
      this.invalidAge = true;
      return;
    }
    if(!this.checkPancardValidity(this.kycForm.get("pan").value)){
      this.invalidPan = true;
      return;
    }
    



    

    //age =  2020-this.kycForm.get("dob").value;
    if(!this.kycForm.invalid)
       //this.router.navigate(["register","addressDetails"])
     //  this.fullAddress = this.addressLine1 + " " + this.addressLine2  + " " + this.addressLine3 + " " +this.addressLine4 + " " +this.addressLine5;
    // sessionStorage.setItem("address",this.fullAddress);
     if(this.addressLine1.length!=0 && this.addressLine2.length!=0 && this.addressLine3.length!=0 && this.addressLine4&& this.addressLine5.length!=0){
      this.fullAddress = this.addressLine1 + " " + this.addressLine2  + " " + this.addressLine3 + " " +this.addressLine4 + " " +this.addressLine5;
      sessionStorage.setItem("address",this.fullAddress);
     this.router.navigate(["register","userRegistration"])
     console.log("nbjeuedygwyujkhgdsjh");
    }
    else
    {
      this.invalidAddressLine1 = true;
      this.invalidAddressLine2=true;
      this.invalidAddressLine3=true;
      this.invalidAddressLine4=true;
      this.invalidAddressLine5=true;
    }

     console.log("helloo");
      
  }

  checkPancardValidity(pan) {
    let letter = /[a-zA-Z]/; 
    let number = /[0-9]/;
    let valid = number.test(pan) && letter.test(pan); //match a letter and a number
    console.log(valid);
    return valid;
    
  }
  get f() { 
    return this.contactForm.controls; 
  }
  get g() { return this.kycForm.controls; }
  
  

  
 




}