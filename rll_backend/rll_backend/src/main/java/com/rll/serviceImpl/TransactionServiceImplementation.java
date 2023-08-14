package com.rll.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rll.dao.PersonalTransactionDao;
import com.rll.dao.PrimaryAccountDao;
import com.rll.dao.TransactionRepository;
import com.rll.exceptions.InvalidAccountException;
import com.rll.model.PersonalTransaction;
import com.rll.model.PrimaryAccount;
import com.rll.model.Transaction;
import com.rll.service.TransactionService;


@Service
public class TransactionServiceImplementation implements TransactionService{
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private PrimaryAccountDao primaryAccountDao;
    
    @Autowired
    private PersonalTransactionDao personalAccount;

    @Override
    public List<PersonalTransaction> retrieveTransactionsAccount(int accountNumber) {
        
        return personalAccount.retrieveTransactionsForAccount(accountNumber);
    }
    @Override
    public List<Transaction> retrieveTransactionsForAccount(int accountNumber) {
        
        return transactionRepository.retrieveTransactionsForAccount(accountNumber);
    }
    
    @Override
    public void transferMoney(Transaction transaction) {

       PrimaryAccount sourceAccount = 
        		primaryAccountDao.findByAccountNumber(transaction.getSourceAccountnumber());
        PrimaryAccount destinationAccount = 
        		primaryAccountDao.findByAccountNumber(transaction.getDestinationAccountnumber());
        if (sourceAccount==null || destinationAccount==null) {
            throw new InvalidAccountException(
                    "Invalid source account " + "or destination account ");
        }

        transaction.runValidationTests(
                sourceAccount, destinationAccount);

        Long transactionAmount = 
                transaction.getTransactionAmount();
        sourceAccount.setAccountBalance(
                sourceAccount.getAccountBalance() - transactionAmount); // subtraction logic
        destinationAccount.setAccountBalance(
                destinationAccount.getAccountBalance() + transactionAmount); // addition logic

        transactionRepository.save(transaction);

        primaryAccountDao.save(sourceAccount);
        primaryAccountDao.save(destinationAccount);

    }

	@Override
	public int retreiveAccountNumber(Long id) {
		Optional<PrimaryAccount> account =  primaryAccountDao.findById(id);
		int accNo = account.get().getAccountNumber();
		return accNo;
	}
    

}
