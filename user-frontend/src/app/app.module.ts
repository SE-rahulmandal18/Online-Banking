import { BankserviceService } from './bankservice.service';
import { UpdateserviceService } from './updateservice.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import { UserRegistrationComponent } from './registration/subComponents/user-registration/user-registration.component';
import { HomepageComponent } from './homepage/homepage.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { ChequebookRequestComponent } from './chequebook-request/chequebook-request.component';
import { TransferFundsComponent } from './transfer-funds/transfer-funds.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import {HttpClientModule}  from '@angular/common/http';
import { DepositFundsComponent } from './deposit-funds/deposit-funds.component';
import { WithdrawFundComponent } from './withdraw-fund/withdraw-fund.component';
import { PrimaryAccountComponent } from './primary-account/primary-account.component';
import { SavingAccountComponent } from './saving-account/saving-account.component';
import { LoanRequestComponent } from './loan-request/loan-request.component';
import { UpdateUserComponent } from './update-user/update-user.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    UserRegistrationComponent,
    HomepageComponent,
    NavbarComponent,
    UserHomeComponent,
    ChequebookRequestComponent,
    TransferFundsComponent,
    UserProfileComponent,
    DepositFundsComponent,
    WithdrawFundComponent,
    PrimaryAccountComponent,
    SavingAccountComponent,
    LoanRequestComponent,
    UpdateUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
  ],
  providers: [UpdateserviceService,BankserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }