package com.example.demo.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class Users {

	
	public Users(int userid, String name, String email) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
	}
	private int userid;
	private String name;
	private String email;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
	

}
