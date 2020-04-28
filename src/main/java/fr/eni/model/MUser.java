package fr.eni.model;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.ManyToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<MCategorie> categories ;
	
	@ManyToMany(cascade = CascadeType.ALL)
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
    for(MCategorie categorie: categories) {
    	categorie.setUser(this);
    }
}



	public Collection<MTache> getTaches() {
		return taches;
	}



	public void setTaches(List<MTache> taches) {
		this.taches = taches;
	}
	
	
	public void addCategorie(MCategorie categorie) {
		this.categories.add(categorie);
		categorie.setUser(this);
	}



	public MUser(String firstname, String lastName, String login, String password) {
		this.firstname = firstname;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.categories = new ArrayList<MCategorie>();
		this.taches = new ArrayList<MTache>();
	}


	public MUser() {
		this.categories = new ArrayList<MCategorie>();
		this.taches = new ArrayList<MTache>();
	}
	
	
	
	
	
	
	
}
