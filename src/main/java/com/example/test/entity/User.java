package com.example.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

///////////////////FIELDS/////////////////////////////////
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "type_user_id")
	private TypeUser typeUser;
	
//////////////////////////CONSTRUCTORS////////////////////////////
	
	public User() {
	}

	public User(String name, String firstName, String email) {

		this.name = name;
		this.firstName = firstName;
		this.email = email;
	}

//////////////////////////GETTERS & SETTERS///////////////////////
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public TypeUser getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}

////////////////////////////////METHOD/////////////////////////////////////////////
	
	@Override
	public String toString() {
		return "User [name=" + name + ", firstName=" + firstName + ", email=" + email + "]";
	}

}
