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

	 

	public List<MUser> selectByUser(MUser utilisateur) {
	    
	        String req = "Select Object(c) from MCategorie c WHERE c.user LIKE :user";
	        return UtilDAO.getEntityManager().createQuery(req, MUser.class).setParameter("user", "%" + utilisateur + "%").getResultList();
	    }

	 

	public List<MCategorie> selectAll()
	{
	    String req = "Select Object(c) from MCategorie c";
	    return  UtilDAO.getEntityManager().createQuery(req,MCategorie.class).getResultList();
	    }
}
