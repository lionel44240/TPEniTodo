package fr.eni.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class MUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="listCategories")
    private List<MCategorie> categories ;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="listTache")
    private List<MTache> taches ;
	
	
	
	public int getId() {
		return id;
	}


	public String getFirstname() {
		return firstname;
	}


	public String getLastName() {
		return lastName;
	}


	public String getLogin() {
		return login;
	}


	public String getPassword() {
		return password;
	}


	public Collection<MCategorie> getCategories() {
		return categories;
	}

	
	public void setCategories(List<MCategorie> categories) {
		this.categories = categories;
	}



	public Collection<MTache> getTaches() {
		return taches;
	}



	public void setTaches(List<MTache> taches) {
		this.taches = taches;
	}



	public MUser(String firstname, String lastName, String login, String password) {
		this.firstname = firstname;
		this.lastName = lastName;
		this.login = login;
		this.password = password;

	}


	public MUser() {
	}
	
	
	
	
	
	
	
}
