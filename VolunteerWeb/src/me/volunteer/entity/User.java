package me.volunteer.entity;

import java.util.Calendar;

public class User {
	
	
	
	int id;
	String email;
	String hashedPassword;
	String name;
	Calendar dob;
	String gender;
	String personalStatement;
	String imageLink;
	boolean isAdmin;
	
	public User(String email, String hashedPassword, String name){
		
		this.name = name;
		this.email = email;
		this.hashedPassword = hashedPassword;
		
	}
	
	public User(int id, String email, String hashedPassword, String name, Boolean isAdmin){
		
		this(email, hashedPassword,name);
		this.id = id;
		this.isAdmin = isAdmin;
	}
	
	public int getId(){
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPersonalStatement() {
		return personalStatement;
	}

	public void setPersonalStatement(String personalStatement) {
		this.personalStatement = personalStatement;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
	
	
}
