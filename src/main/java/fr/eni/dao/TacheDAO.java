package fr.eni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.exception.DAOException;
import fr.eni.model.MTache;

public class TacheDAO {

	public void add(MTache tache) throws DAOException {
		EntityManager em = UtilDAO.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(tache);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw new DAOException("Erreur lors de l'ajout de la Tache " +  tache + " : " + e.getMessage());
		}
	}

	public void update(MTache tache) throws DAOException {
		EntityManager em = UtilDAO.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(tache);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw new DAOException("Erreur lors de la modification de la Tache " + tache + " : " + e.getMessage());
		}
	}
	
	
	public MTache findByidTache(int idTache) {
			
			return UtilDAO.getEntityManager().find(MTache.class, idTache);
		}
	
	public List<MTache> finByIdCategorie(int idCategorie) {
		String req = "Select Object(l) from TACHE l WHERE l.categorie LIKE :idcat";
		return UtilDAO.getEntityManager().createQuery(req, MTache.class).setParameter("idcat", "%" + idCategorie + "%").getResultList();
	}
}
