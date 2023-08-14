import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UpdateserviceService {

  constructor(public http:HttpClient) { }
  
  updDatabackend(mobileno:any,data){
    console.log("called"+mobileno+data);
    
   return this.http.put("http://localhost:8090/upduser/"+mobileno,data);
  }
}
