package com.rll.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rll.dao.PersonalTransactionDao;
import com.rll.dao.SavingsAccountDao;
import com.rll.exceptions.AccountNotFoundException;
import com.rll.model.PersonalTransaction;
import com.rll.model.SavingsAccount;
import com.rll.service.SavingsAccountService;
import com.rll.service.UserService;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService{

    @Autowired
    private SavingsAccountDao savingsAccountDao;
    
    @Autowired
    private UserService userService;
	private static int nextAccountNumber = 11223344;
	
	
	@Autowired
	private PersonalTransactionDao personalTransactionDao;
	
	@Override
	public SavingsAccount createSavingsAccount() {
	        SavingsAccount savingsAccount = new SavingsAccount();
	        savingsAccount.setAccountBalance(new Long(0));
	        nextAccountNumber += 1;
	        savingsAccount.setAccountNumber(nextAccountNumber);
	        System.out.println(savingsAccount);
	        savingsAccountDao.save(savingsAccount);

	        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
	    }
	@Override 
	public void deposit( Integer accNo, Long amount) {
				SavingsAccount savingsAccount = savingsAccountDao.findByAccountNumber(accNo);
				Long prevBal = savingsAccount.getAccountBalance();
				Long newBal = savingsAccount.getAccountBalance() + amount;
		        savingsAccount.setAccountBalance((long) (savingsAccount.getAccountBalance() + amount) );
		        savingsAccountDao.save(savingsAccount);
		        Date date = new Date();
		        PersonalTransaction personalTransaction = new PersonalTransaction(accNo , date, prevBal, newBal, "Deposit" ,"Savings");
		        personalTransactionDao.save(personalTransaction);
	        }
	    
	    
	    public String withdraw(Integer accNo, Long amount) {
	    	    SavingsAccount savingsAccount = savingsAccountDao.findByAccountNumber(accNo);
	    	    if(savingsAccount.getAccountBalance()>=amount) {
	    	    	Long prevBal = savingsAccount.getAccountBalance();
	    	    	Long newBal = savingsAccount.getAccountBalance() - amount;
	    	    	savingsAccount.setAccountBalance(newBal);
		            savingsAccountDao.save(savingsAccount);
		            Date date = new Date();
			        PersonalTransaction personalTransaction = new PersonalTransaction(accNo ,date, prevBal, newBal, "Withdraw" ,"Savings");
			        personalTransactionDao.save(personalTransaction);
			        return "Done";
	    	    }
	    	    else {
	    	    	return "Insufficient balance";
	    	    }
	            
	    }
	    
	   
		@Override
		public List<SavingsAccount> getAllSavingsAccounts() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SavingsAccount getAccount(int accNo) {
			return savingsAccountDao.findByAccountNumber(accNo);
		}
		
		
		 @Override
		    public Long retrieveAccountBalance(long accountId) {
		        Optional<SavingsAccount> account = savingsAccountDao.findById(accountId);
		        if (!account.isPresent()) {
		            throw new AccountNotFoundException(
		                  String.format("Account %s not found.", accountId));
		        }
		        return account.get().getAccountBalance();
		    }
}
