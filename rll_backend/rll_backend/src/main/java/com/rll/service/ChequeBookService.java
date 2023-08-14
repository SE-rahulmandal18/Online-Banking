package com.rll.service;

import java.util.List;

import com.rll.model.ChequeBook;
import com.rll.model.Loan;
import com.rll.model.User;

public interface ChequeBookService {
	public ChequeBook createChequeBook(ChequeBook chequebook,User user);
	public List<ChequeBook> AllChequeBooks();
	public ChequeBook findChequebookById(long id);
	public void ChequeBookRequestTrue(long id);
	public void ChequeBookRequestFalse(long id);
	
}
