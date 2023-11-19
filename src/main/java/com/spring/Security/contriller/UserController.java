package com.spring.Security.contriller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Security.models.User;
import com.spring.Security.serviceimpl.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	UserService usersimpl;
	
	
	@GetMapping("/getall")
	public List<User> getall(){
	
		return usersimpl.getallusers();
	}
	
	@GetMapping("/{username}")
	public User getSingleuser(@PathVariable("username") String username){
		
		return usersimpl.getUser(username);
		
	}
	
	@PostMapping("/add")
	public User add(@RequestBody User user) {
		return usersimpl.addUser(user);
	}
	
	
	

}
