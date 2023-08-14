package com.rll.dao;

import org.springframework.data.repository.CrudRepository;

import com.rll.model.PrimaryAccount;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber (int accountNumber);

}
