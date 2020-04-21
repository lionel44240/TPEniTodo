package fr.eni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class MUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "FIRSTNAME")
	private String firstname;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "PASSWORD")
	private String password;
	
	
	public String getId() {
		return firstname;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public MUser() {
	}
	
	public MUser(int id, String firstname, String lastName, String login, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
	}
	
	public MUser(String firstname, String lastName, String login, String password) {
		this.firstname = firstname;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserDAO [firstname=" + firstname + ", lastName=" + lastName + ", login=" + login + "]";
	}
}
