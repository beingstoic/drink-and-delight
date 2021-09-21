package com.cg.dnd.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message="User Name can not be empty")
	@NotNull(message="User Name can not be omitted")
	@Column(name="Username")
	private String username;
	
	@NotEmpty(message="Password can not be empty")
	@NotNull(message="Password can not be omitted")
	@Column(name="Password")
	@JsonIgnore
	private String password;	

	@Column(name="Gender")
	private String gender;
	
	@Column(name="EmailId")
	private String emailId;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
