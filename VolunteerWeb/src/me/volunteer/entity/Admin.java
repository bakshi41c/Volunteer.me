package me.volunteer.entity;

public class Admin extends User{

	public Admin(String email, String hashedPassword) {
		super(email, hashedPassword, email);
		
	}
	
	public void setAnotherAdmin(User user){
		
	}
	
	public void approveOppurtunity(Oppurtunity oppurtunity){
		
	}
	
}
