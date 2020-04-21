package fr.eni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIE")
public class MCategorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "LIBELLE")
	private String libelle;

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

	public MCategorie(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}	
	
	public MCategorie( String libelle) {
		this.libelle = libelle;
	}	
	public MCategorie() {
	}

	@Override
	public String toString() {
		return "MCategorie [id=" + id + ", libelle=" + libelle + "]";
	}	
}
