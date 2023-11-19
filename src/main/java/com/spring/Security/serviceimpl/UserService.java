package com.spring.Security.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.Security.models.User;

@Service
public class UserService {
	
	
	List<User> list=new ArrayList<>();
	
	public UserService() {
		
		list.add(new User("ABC","abc@123","ABC@gmail.com"));
		list.add(new User("PQR","pqr@123","PQR@gmail.com"));
		list.add(new User("XYZ","xyz@123","XYZ@gmail.com"));
	}

	
	public List<User> getallusers(){
		
		return this.list;
	}
	
	public User getUser(String username) {
		
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
			
	}
	
	public User addUser(User user) {
		
		this.list.add(user);
		return user;
	}
	
	
	
	
}
