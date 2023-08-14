package com.rll.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rll.model.PersonalTransaction;

public interface PersonalTransactionDao extends JpaRepository<PersonalTransaction, Integer>{
//	  @Query("SELECT transaction FROM PersonalTransaction transaction "
//	            + "WHERE transaction.sourceAccountnumber = ?1"
//	            + "OR transaction.destinationAccountnumber = ?1")
//	@Query("SELECT transaction FROM PersonalTransaction transaction "
//    + "WHERE transaction.accNo = ?1")
	@Query(value="select * from personal_transaction where acc_no=?",nativeQuery=true)
	    List<PersonalTransaction> retrieveTransactionsForAccount(int accountId);
	   // @Query("select u from User u where u.userid=:userid")
}
