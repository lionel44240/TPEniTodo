package fr.eni.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class MUser {
	
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
	
	@OneToMany
	@JoinColumn(name="listCategories")
    private Collection<MCategorie> categories ;
	
	@OneToMany
	@JoinColumn(name="listTache")
    private Collection<MTache> taches ;
	
	
	
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



	public void setCategories(Collection<MCategorie> categories) {
		this.categories = categories;
	}



	public Collection<MTache> getTaches() {
		return taches;
	}



	public void setTaches(Collection<MTache> taches) {
		this.taches = taches;
	}



	public MUser() {
	}
	
	
	
	
	
	
	
}
