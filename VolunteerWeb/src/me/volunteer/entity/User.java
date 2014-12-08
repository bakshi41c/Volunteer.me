package me.volunteer.entity;

import java.util.Calendar;

public class User {
	
	String email;
	String hashedPassword;
	String firstName;
	String lastName;
	Calendar dob;
	String gender;
	String personalStatement;
	String imageLink;
	boolean isAdmin;
	
	public User(String email, String hashedPassword){
		
	}
		
	public String getFirstName(){ return firstName; }
	
	public String getLastName(){ return lastName; }
	
	public String getHashedPassword(){ return hashedPassword; }
	
	public Calendar getDOB() { return dob; }
	
	public String getGender() { return gender; }
	
	public String getPersonalStatement() { return personalStatement; }
	
	public String getImageLink() { return imageLink; }
	
	public boolean isAdmin() { return isAdmin; }
	
	
}
