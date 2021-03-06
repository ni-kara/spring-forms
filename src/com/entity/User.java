package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	@Column(name = "firstName")
	@NotNull(message = "is required")
	@Size(min = 3, max = 25, message = "the length char of must between 3 to 25")
	@Pattern(regexp = "([a-zA-Z][a-zA-Z0-9]*$)", message = "Non valid")
	private String firstName;

	@Column(name = "lastName")
	@NotNull(message = "is required")
	@Size(min = 3, max = 25, message = "the length char of must between 3 to 25")
	@Pattern(regexp = "([a-zA-Z][a-zA-Z0-9]*$)", message = "Non valid")
	private String lastName;

	@Column(name = "email", unique = true)
	@NotNull(message = "is required")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9.]*@[a-z]*\\.[a-z]+", message = "Non valid")
	private String email;

	@Id
	@Column(name = "username")
	@NotNull(message = "is required")
	@Size(min = 3, max = 25, message = "the length char of must between 3 to 25")
	@Pattern(regexp = "([a-zA-Z][a-zA-Z0-9.-]*$)", message = "Non valid")
	private String username;

	@Column(name = "password")
	@NotNull(message = "is required")
	@Size(min = 3, max = 68, message = "the length char of must between 3 to 68")
	private String password;

	@Column(name = "country")
	@NotNull(message = "is required")
	private String country;

	@Column(name = "role")
	@NotNull(message = "is required")
	private String role;

	public User() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", country=" + country + ", role=" + role + "]";
	}
}
