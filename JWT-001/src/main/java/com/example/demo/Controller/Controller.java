package com.example.demo.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Users;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/home")
public class Controller {
	
	@Autowired
	UserService user;
	
	@GetMapping("/user")
	public List<Users> userMessage() {
		System.out.println(user.listOfUsers());
		return user.listOfUsers();
		}	
	@GetMapping("/get-user")
	public String getUSer(Principal princi) {
		return princi.getName();
	}
}
