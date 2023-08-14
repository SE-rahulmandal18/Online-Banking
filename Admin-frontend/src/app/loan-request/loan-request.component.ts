import { Component, OnInit } from '@angular/core';
import { LoanRequestService } from '../loan-request.service';
@Component({
  selector: 'app-loan-request',
  templateUrl: './loan-request.component.html',
  styleUrls: ['./loan-request.component.css']
})
export class LoanRequestComponent implements OnInit {
  [x: string]: any;

 loanRequestList: Object[];

	constructor(private loanRequestService: LoanRequestService) {
		this.getLoanRequestList();
	}

	getLoanRequestList() {
		this.loanRequestService.getLoanRequestList().subscribe(
			res => {
				this.loanRequestList = JSON.parse(JSON.stringify(res));
				console.log(this.loanRequestList);
      		},
      		error => console.log(error)
		)
	}	

	confirmLoanRequest(id: number) {
  		this.loanRequestService.confirmLoanRequest(id).subscribe();
  		location.reload();
  	}

  ngOnInit(): void {
  }

}
