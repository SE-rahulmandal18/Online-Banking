package com.rll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rll.dao.MyRepo;
import com.rll.model.User;

@Service
public class AdminService {
	@Autowired
    MyRepo repo;
	
	public List<User> getAllUsers(){
		return (List<User>) repo.findAll();
		
	}
	
	public User getUserById( long id) {
		return repo.findById(id);
		
	}
	
	public void deleteById(long id) {
		repo.delete(repo.findById(id));
		
	}	
	
}
