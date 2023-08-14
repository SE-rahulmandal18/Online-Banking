package com.rll.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rll.model.Loan;

public interface LoanDao extends JpaRepository<Loan,Long> {

}
