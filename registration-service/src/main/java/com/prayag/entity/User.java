package com.prayag.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class User {
	
	public User(){
		
	}
	
	
	public User(String name, String email,String address,String picLink) {
		this.name=name;
		this.email=email;
		this.address=address;
		this.picLink=picLink;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer registrationId;
	
	private String name;
	
	private String email;
	
	private String address;
	
	private String  picLink;
	
	

	public Integer getRegistrationId() {
		return registrationId;
	}


	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPicLink() {
		return picLink;
	}


	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}


	@Override
	public String toString() {
		return "User [registrationId=" + registrationId + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", picLink=" + picLink + "]";
	}
	

}























