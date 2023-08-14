package com.rll.dao;


import org.springframework.data.repository.CrudRepository;

import com.rll.model.SavingsAccount;


public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber (int accountNumber);

}
