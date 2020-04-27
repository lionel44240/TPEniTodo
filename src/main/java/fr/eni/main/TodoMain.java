package fr.eni.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.eni.dao.CategorieDAO;
import fr.eni.dao.UserDAO;
import fr.eni.model.MCategorie;
import fr.eni.model.MTache;
import fr.eni.model.MUser;

public class TodoMain {

	public static void main(String[] args) {

		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		UserDAO userDAO = new UserDAO();
        CategorieDAO categorieDAO = new CategorieDAO();
        MTache tache = new MTache();
        List<MTache> listTaches1 = new ArrayList<MTache>();
        List<MTache> listTaches2 = new ArrayList<MTache>();
        List<MTache> listTaches3 = new ArrayList<MTache>();
        List<MTache> listTaches4 = new ArrayList<MTache>();

		
		MUser utilisateur1 = new MUser("Jean", "DUPONT", "Jdupont", "Passw0rd1");
        MUser utilisateur2 = new MUser("Martin", "PERROUIN", "MPerrouin", "Passw0rd2");
        MUser utilisateur3 = new MUser("Alice", "MERCIER", "AMercier", "Passw0rd3");
        MUser utilisateur4 = new MUser("Danielle", "LARVOL", "DLarvol", "Passw0r4");

        MCategorie categorie1 = new MCategorie("Administratif");
        MCategorie categorie2 = new MCategorie("Loisir");
        MCategorie categorie3 = new MCategorie("Travaux");
        
        MTache tache1 = new MTache("courses", "acheter une voiture",date,true );
        MTache tache2 = new MTache("courses", "carrottes",date,true );
        MTache tache3 = new MTache("courses", "poulet",date,true );
        MTache tache4 = new MTache("courses", "casque",date,true );

        


        try {
            
			 // AJout des categories dans une liste
            listTaches1.add(tache1);
            listTaches2.add(tache2);
            listTaches3.add(tache3);
            listTaches4.add(tache4);
			            
            // Ajout des catégories à chaque utilisateur
            utilisateur1.addCategorie(categorie1);
            utilisateur2.addCategorie(categorie2);
            utilisateur3.addCategorie(categorie3); 
            
            // Ajout des catégories à chaque utilisateur
            utilisateur1.setTaches(listTaches1);
            utilisateur2.setTaches(listTaches2);
            utilisateur3.setTaches(listTaches3);
            utilisateur4.setTaches(listTaches4);
            
            userDAO.add(utilisateur1);
            userDAO.add(utilisateur2);
            userDAO.add(utilisateur3);
            userDAO.add(utilisateur4);

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
		/*
		 * List<MCategorie> categorieListByUser =
		 * categorieDAO.selectByUser(utilisateur1);
		 * 
		 * for (MCategorie mCategorie : categorieListByUser) {
		 * System.out.println(mCategorie.getLibelle()); }
		 */
        

        List<MCategorie> categorieList =  categorieDAO.selectAll();
 
        for (MCategorie mCategorie : categorieList) {
        	System.out.println(mCategorie.getLibelle());
		}
		
	}

}
