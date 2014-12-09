package me.volunteer.entity;

import java.util.Calendar;

public class Oppurtunity {
	
	int id;
	String title;
	String description;
	String address;
	int organizationId;
	String category;
	Calendar postDate;
	boolean approved;
	
	public Oppurtunity(String desctiption, String address, int organizationId, 
			String category, Calendar postDate, Boolean approved){
		this.description = desctiption;
		this.address = address;
		this.organizationId = organizationId;
		this.postDate= postDate;
		this.approved = approved;
	}
	
	public Oppurtunity(int id, String desctiption, String address, int organizationId, 
			String category, Calendar postDate, Boolean approved){
		
		this (desctiption, address, organizationId,category, postDate, approved);
		this.id = id;
		
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getAddress() {
		return address;
	}

	public int getOrganizationId() {
		return organizationId;
	}
	
	public String getCategory() {
		return category;
	}
	
	public Calendar getPostDate() {
		return postDate;
	}

	public boolean isApproved() {
		return approved;
	}
	
	
}
