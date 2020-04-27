package fr.eni.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TACHE")
public class MTache implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@Column(name = "etat")
	private Boolean etat;
	
	@ManyToOne 
    @JoinColumn(name="user")
    private MUser user;
    
    @ManyToMany 
    @JoinTable( name = "TacheCategorie", joinColumns = @JoinColumn(name="tacheId"), inverseJoinColumns = @JoinColumn(name="categorieId"))
    private List<MCategorie> categorie;
    
    
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

	
	public Boolean getEtat() {
		return etat;
	}


	public void setEtat(Boolean etat) {
		this.etat = etat;
	}


	public MUser getUser() {
		return user;
	}


	public void setUser(MUser user) {
		this.user = user;
	}


	public List<MCategorie> getCategorie() {
		return categorie;
	}


	public void setCategorie(List<MCategorie> categorie) {
		this.categorie = categorie;
	}


	public MTache(String type, String description, java.util.Date date, Boolean etat) {
	
		this.type = type;
		this.description = description;
		Date = date;
		this.etat = etat;

	
	}


	public MTache() {
	}
	
	
	
}
