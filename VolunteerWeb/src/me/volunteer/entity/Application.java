package me.volunteer.entity;

import java.util.Calendar;

public class Application {
	
	int id;
	Calendar date;
	int userId;
	int oppurtunityId;
	
	public Application(Calendar date, int userId, int oppurtunityId){
		
		this.date = date;
		this.userId = userId;
		this.oppurtunityId = oppurtunityId;
	}
	
	public Application(int id, Calendar date, int userId, int oppurtunityId){
		
		this (date, userId, oppurtunityId);
		this.id = id;
	
	}
	
	public int getId() {
		return id;
	}

	public Calendar getDate() {
		return date;
	}

	public int getUserId() {
		return userId;
	}

	public int getOppurtunityId() {
		return oppurtunityId;
	}

	
}
