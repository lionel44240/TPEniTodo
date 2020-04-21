package fr.eni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import fr.eni.exception.DAOException;
import fr.eni.model.MUser;

public class UserDAO {

	public void add(MUser user) throws DAOException {
		EntityManager em = UtilDAO.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(user);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw new DAOException("Erreur lors de l'ajout de User " + user + " : " + e.getMessage());
		}
	}

	/*
	 * public void update(MUser user) throws DAOException { EntityManager em =
	 * UserDAO.getEntityManager(); EntityTransaction et = em.getTransaction();
	 * et.begin(); try { em.merge(user); et.commit(); } catch (Exception e) {
	 * et.rollback(); throw new
	 * DAOException("Erreur lors de la modification du User " + user + " : " +
	 * e.getMessage()); } }
	 */

	public MUser findByLoginPass(String login) {
		
		return UtilDAO.getEntityManager().find(MUser.class, login);
	}

	

}
