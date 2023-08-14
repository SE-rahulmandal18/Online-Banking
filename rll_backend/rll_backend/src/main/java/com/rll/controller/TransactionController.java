package com.rll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rll.model.Transaction;
import com.rll.service.TransactionService;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
 
    @PostMapping(path = "/transfer")
    @CrossOrigin(origins = "http://localhost:4200")
    public Object transferMoney(@RequestBody Transaction transaction) {

    	  transactionService.transferMoney(transaction);
         
          return transaction;
        

    }
}
