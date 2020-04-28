package fr.eni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.exception.DAOException;
import fr.eni.model.MCategorie;
import fr.eni.model.MUser;

public class CategorieDAO {
	
	
	public void add(MCategorie categorie) throws DAOException {
	    EntityManager em = UtilDAO.getEntityManager();
	    EntityTransaction et = em.getTransaction();
	    et.begin();
	    try {
	        em.persist(categorie);
	        et.commit();
	    } catch (Exception e) {
	        et.rollback();
	        throw new DAOException("Erreur lors de l'ajout de la categorie " + categorie + " : " + e.getMessage());
	    }
	}
	


	 

	

	public List<MCategorie> selectCategorieByUser( MUser utilisateur) {
	    
        String req = "Select c from MCategorie c WHERE c.user.id = :utilisateur";
        try {
        	return UtilDAO.getEntityManager().createQuery(req, MCategorie.class).setParameter("utilisateur",utilisateur.getId()).getResultList();
		}
        catch (Exception e) {
				System.out.println(e);
		}
		return null;
        
    }

	public List<MCategorie> selectAll()
	{
	    String req = "Select Object(c) from MCategorie c";
	    return  UtilDAO.getEntityManager().createQuery(req,MCategorie.class).getResultList();
	    }
}
