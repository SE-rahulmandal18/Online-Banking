package com.rll.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rll.dao.UserRepo;
import com.rll.model.Admin;
import com.rll.model.PrimaryAccount;
import com.rll.model.SavingsAccount;
import com.rll.model.User;
import com.rll.service.UserService;
import com.rll.serviceImpl.RegisterService;

@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping
@RestController
public class UserController {

	
	private User user1;
	@Autowired
	RegisterService registerService;

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepo repo;
	
	@RequestMapping(path="/hello", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public String testMessage()
	{
		return "Hello World";
	}

	
	@RequestMapping(path="/register", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerAddUser(@RequestBody User user)
	{
		User Obj;
		Obj=registerService.addUser(user);
		System.out.println(Obj);
		return Obj;
	}
	
	@PutMapping("/upduser/{mobileno}")
	public String userUpdData(@PathVariable String mobileno,@RequestBody User user) {
		User ur=repo.findByMailid(mobileno);
		
		ur.setAddress(user.getAddress());
		ur.setFullname(user.getFullname());
		ur.setMailid(user.getMailid());
		ur.setPhonenumber(user.getPhonenumber());
		ur.setPassword(user.getPassword());
		ur.setSurname(user.getSurname());
		repo.save(ur);
		return "Details updated";
	}	
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public User doLogin(@RequestBody User user) throws Exception
	{
		String temperorymail = user.getMailid();
		String temperorypassword = user.getPassword();
		User Obj = null;
		if(temperorymail != null && temperorypassword != null)
		{
			Obj = registerService.matchEmailPassword(temperorymail, temperorypassword);
		}
		
		if(Obj == null)
		{
			throw new Exception("====User not exist=====");
		}
		return Obj;
	}
	
	
	@RequestMapping(path = "/admin", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4201")
	public void doAdminLogin(@RequestBody Admin admin) throws Exception
	{
		String adminemail = admin.getEmailid();
		String adminpassword = admin.getPassword();
		
		if(adminemail.equals("admin") && adminpassword.equals("admin"))
		{
			System.out.println("admin successfully login");
		}
		else
		{
			throw new Exception("credentials are wrong");
		}
		
		
	}
	
	@PostMapping("/home" )
	@CrossOrigin(origins = "http://localhost:4200")
	public List getHome(@RequestBody String email) {
		List<Object> accounts = new ArrayList<Object>();
		user1 = userService.findByEmail(email);
		System.out.println(user1);
        //model.addAttribute("savingsAccount", savingsAccount);
		PrimaryAccount primaryAccount = user1.getPrimaryAccount();
	    SavingsAccount savingsAccount = user1.getSavingsAccount();
	    //System.out.println(savingsAccount);
	    accounts.add(savingsAccount);
	    accounts.add(primaryAccount);
	    return accounts;
    }
	
//	@GetMapping("/home" )
//	@CrossOrigin(origins = "http://localhost:4200")
//	public SavingsAccount getHome() {
//		PrimaryAccount primaryAccount = user1.getPrimaryAccount();
//	    SavingsAccount savingsAccount = user1.getSavingsAccount();
//	    System.out.println(savingsAccount);
//	    return savingsAccount;
//	}
	
}