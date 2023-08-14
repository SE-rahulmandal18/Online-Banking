package com.rll.service;

import java.util.List;

import com.rll.model.PersonalTransaction;
import com.rll.model.PrimaryAccount;
import com.rll.model.Transaction;

public interface TransactionService {

    //public List<Transaction> retrieveTransactionsForAccount(long accountId);
    
    public void transferMoney(Transaction transaction);
    
    public int retreiveAccountNumber(Long id);
    List<PersonalTransaction> retrieveTransactionsAccount(int accountNumber);
	List<Transaction> retrieveTransactionsForAccount(int accountNumber);
}
