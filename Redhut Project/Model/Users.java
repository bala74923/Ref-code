package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users 
{
	@Id
	public long Aadhar_id;
	public String name;
	public  String email;
	
	// getters and  setters
	public long getAadhar_id() {
		return Aadhar_id;
	}
	public void setAadhar_id(long aadhar_id) {
		this.Aadhar_id = aadhar_id;
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
		return "Users [aadhar_id=" + Aadhar_id + ", name=" + name + ", email=" + email + "]";
	}
	public Users(long aadhar_id, String name, String email) {
		super();
		this.Aadhar_id = aadhar_id;
		this.name = name;
		this.email = email;
	}
	public Users() {
		super();
	}
	public Users(long aadhar_id, String name) {
		super();
		this.Aadhar_id = aadhar_id;
		this.name = name;
	}
	
	
}
