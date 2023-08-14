package com.rll.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rll.model.Loan;
import com.rll.model.User;
import com.rll.service.LoanService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class LoanController{
	
	@Autowired
	LoanService service;

	@PostMapping("/createloan")
	@CrossOrigin(origins = "http://localhost:4200")
	public Loan createLoan(@RequestBody Loan loan) {
		System.out.println(loan);
		User user = loan.getUser();
		return service.createLoan(loan,user);
		
	}

	@GetMapping("/allloan")
	public List<Loan> AllLoans() {
		return service.AllLoans();
	}

	@GetMapping("/getloan/{id}")
	public Loan findLoanById(@PathVariable("id") long id) {
		return service.findLoanById(id);
	}

	@GetMapping("/admin/confirmloantrue/{id}")
	public void LoanRequestTrue(@PathVariable("id") long id) {
		service.LoanRequestTrue(id);
		
	}

	@GetMapping("/admin/confirmloanfalse/{id}")
	public void LoanRequestFalse(long id) {
		service.LoanRequestFalse(id);
	}
	

}
