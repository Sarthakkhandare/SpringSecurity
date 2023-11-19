package com.spring.Security.contriller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Security.models.student;

import lombok.var;

@RestController
@RequestMapping("/home")
public class BaseController {

	
	@PreAuthorize("hasRole('NORMAL')")    //this is advance to autorized role
	@GetMapping("/normal")
	public ResponseEntity<String> normaluser(){
		return ResponseEntity.ok("Yes,This is normal user");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminuser(){
		return ResponseEntity.ok("Yes,This is admin user");
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> publicuser(){
		return ResponseEntity.ok("Yes,This is public user");
	}
	
	@RequestMapping("/just")
	public ResponseEntity<student>getRecord(){
		var address="""
				215/101
				Karvenager pune
				pin-401401
				""";
	var student =new student(101, "sarthak", address);
	
	return ResponseEntity.ok(student);
		
	}
	
	
	
	
	
	
	
	
	
	
}



