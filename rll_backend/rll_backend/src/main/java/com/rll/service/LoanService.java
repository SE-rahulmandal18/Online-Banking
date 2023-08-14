package com.rll.service;

import java.util.List;

import com.rll.model.Loan;
import com.rll.model.User;

public interface LoanService {
	public Loan createLoan(Loan Loan,User user);
	public List<Loan> AllLoans();
	public Loan findLoanById(long id);
	public void LoanRequestTrue(long id);
	public void LoanRequestFalse(long id);
	

}