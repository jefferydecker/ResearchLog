package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Citation;
import model.Source;

public class SourceHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ResearchLog");

	public void insertSource(Source s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public Source searchForSourceById(int idToEdit) {
		// TODO Auto-generated method stub
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

	public void deleteSource(Source toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Source> typedQuery = em.createQuery(
				"select s from sources s where s.srcId = :selectedsrcId", Source.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedsrcId", toDelete.getSrcId());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Source result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}


	public void updateSource(Source toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void cleanUp(){
		emfactory.close();
	
}

	public List<Citation> viewSourceCitations(Source sourceToView) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Citation> typedQuery = em.createQuery(
				"select c from Citation c where c.srcId = :selectedsrcId", Citation.class);
		typedQuery.setParameter("selectedsrcId", sourceToView);
		List<Citation> foundCitations = typedQuery.getResultList();
		em.close();
		System.out.println(foundCitations.toString());
		return foundCitations;
	}

}