package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Users;

@Service
public class UserService {
	
	List<Users> allUsers= new ArrayList<>();

	public UserService(){
		allUsers.add(new Users(101,"Jamil","JAmil456@gmail.com"));
		allUsers.add(new Users(456,"Rajiyh","Rajiyh@gmail.com"));
		allUsers.add(new Users(956,"kamal","kamal@gmail.com"));
	}
	
	public List<Users> listOfUsers(){
		return allUsers;
		
	}
	

}

















