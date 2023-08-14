package com.rll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Loan {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private boolean accepted;
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User users;
	
	public Loan() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public User getUser() {
		return users;
	}
	public void setUser(User user) {
		this.users = user;
	}
	@Override
	public String toString() {
		return "RequestLoan [id=" + id + ", accepted=" + accepted + ", user=" + users + "]";
	}
	
	
}
