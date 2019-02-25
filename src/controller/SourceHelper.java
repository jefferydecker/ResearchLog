package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Source;

public class SourceHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("ResearchLog");

	public void insertNewSource(Source s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Source> showAllSources() {
		EntityManager em = emfactory.createEntityManager();
		List<Source> allSources =
				em.createQuery("SELECT s FROM Source s").getResultList();
		return allSources;
	}
}