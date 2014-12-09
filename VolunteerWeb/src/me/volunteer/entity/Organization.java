package me.volunteer.entity;

public class Organization {
	
	int id;
	String name;
	String email;
	String hashedPassword;
	String phone;
	String address;
	String about;
	String imageLink;
	
	
	public Organization(String name, String email, String phone, String address, String about, String imageLink, String hashedPassword){
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.about = about;
		this.imageLink = imageLink;
		this.hashedPassword = hashedPassword;
	}
	
	public Organization(int id, String name, String email, String phone, String address, String about, String imageLink, String hashedPassword){
		this(imageLink, imageLink, imageLink, imageLink, imageLink, imageLink, hashedPassword);
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public String getHashedPassword() {
		return hashedPassword;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}


	public String getAbout() {
		return about;
	}


	public String getImageLink() {
		return imageLink;
	}

}
