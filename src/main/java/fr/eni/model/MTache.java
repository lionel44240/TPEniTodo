package fr.eni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TACHE")
public class MTache {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date")
	private java.util.Date Date;
	
	
    @ManyToOne 
    @JoinColumn(name="user")
    private MUser user;
    
    @ManyToOne 
    @JoinColumn(name="categorie")
    private MCategorie categorie;
    
    
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public java.util.Date getDate() {
		return Date;
	}


	public void setDate(java.util.Date date) {
		Date = date;
	}


	public MUser getUser() {
		return user;
	}


	public void setUser(MUser user) {
		this.user = user;
	}


	public MCategorie getCategorie() {
		return categorie;
	}


	public void setCategorie(MCategorie categorie) {
		this.categorie = categorie;
	}


	public MTache() {
	}
	
	
	
}
