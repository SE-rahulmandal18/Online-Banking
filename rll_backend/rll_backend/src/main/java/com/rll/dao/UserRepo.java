package com.rll.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rll.model.User;

public interface UserRepo extends CrudRepository<User, Long> {
//	User findByMailid(String mailid);
//    //Optional<User> findBymobile(Long mobileno);
	User findByFullname(String name);
	
    @Query(value="select * from user where phonenumber=?;",nativeQuery=true)
    User findByMailid(String mailid);

}
