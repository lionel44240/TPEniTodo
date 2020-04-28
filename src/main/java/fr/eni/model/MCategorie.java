package fr.eni.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIE")
public class MCategorie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "LIBELLE")
	private String libelle;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user")
    private MUser user ;
	
	
	@ManyToMany (cascade = CascadeType.ALL, mappedBy = "categorie")
    private Collection<MTache> taches;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public MUser getUser() {
		return user;
	}



	public void setUser(MUser user) {
		this.user = user;
	}



	public Collection<MTache> getTaches() {
		return taches;
	}



	public void setTaches(Collection<MTache> taches) {
		this.taches = taches;
	}



	public MCategorie(String libelle) {
		this.libelle = libelle;
	}



	public MCategorie() {
	}

	
	
}
