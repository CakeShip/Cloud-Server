package com.healthcare.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user") // This tells Hibernate to name the table as User and not User
@DynamicInsert(true)
@DynamicUpdate(true)
public class User {

	public User() {
	};

	public User(Integer id, @NotEmpty String email,
			@NotEmpty @Size(min = 2, message = "Username should at least have 2 characters") @Size(max = 15, message = "Username should not exceed 15 characters") String username,
			@NotEmpty @Size(min = 2, message = "Password should at least have 2 characters") String password,
			@NotNull @NotEmpty @Size(min = 2, message = "First Name should at least have 2 characters") @Size(max = 15, message = "FirstName should not exceed 15 characters") String firstName,
			@NotEmpty @NotEmpty @Size(min = 2, message = "Last Name should at least have 2 characters") @Size(max = 15, message = "Last Name should not exceed 15 characters") String usertype,
			@NotNull @NotEmpty @Size(min = 2, message = "Last Name should at least have 2 characters") @Size(max = 15, message = "Last Name should not exceed 15 characters") String lastName) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.usertype = usertype;
		this.isArchived = false;
	}

	public User(
			@NotEmpty @Size(min = 2, message = "Username should at least have 2 characters") @Size(max = 15, message = "Username should not exceed 15 characters") String username,
			@NotEmpty @Size(min = 2, message = "Password should at least have 2 characters") @Size(max = 15, message = "Password should not exceed 255 characters") String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotEmpty
	@Column(name = "email")
	private String email;

	@NotEmpty
	@Size(min = 2, message = "Username should at least have 2 characters")
	@Size(max = 15, message = "Username should not exceed 15 characters")
	@Column(name = "username", nullable = false, updatable = true)
	private String username;

	@NotEmpty
	@Size(min = 2, message = "UserType should at least have 2 characters")
	@Size(max = 15, message = "UserType should not exceed 15 characters")
	@Column(name = "usertype", nullable = false, updatable = true)
	private String usertype;

	@NotEmpty
	@Size(min = 2, message = "Password should at least have 2 characters")
	@Column(name = "password", nullable = false, updatable = true)
	private String password;

	@NotNull
	@NotEmpty
	@Size(min = 2, message = "First Name should at least have 2 characters")
	@Size(max = 15, message = "FirstName should not exceed 15 characters")
	private String firstName;

	@NotNull
	@NotEmpty
	@Size(min = 2, message = "Last Name should at least have 2 characters")
	@Size(max = 15, message = "Last Name should not exceed 15 characters")
	private String lastName;

	@Column(name = "isArchived", nullable = false)
	private Boolean isArchived;
}
