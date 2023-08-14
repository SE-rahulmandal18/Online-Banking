package com.rll.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rll.model.ChequeBook;

public interface ChequeBookDao extends JpaRepository<ChequeBook,Long> {
	

}
