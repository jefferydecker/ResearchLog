package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Citation;
import model.Source;

public class SourceHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("ResearchLog");

	public void insertSource(Source s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public Source searchForSourceById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Source found = em.find(Source.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<Source> showAllSources() {
		EntityManager em = emfactory.createEntityManager();
		List<Source> allSources =
				em.createQuery("SELECT s FROM Source s").getResultList();
		return allSources;
	}
	
	public 
}