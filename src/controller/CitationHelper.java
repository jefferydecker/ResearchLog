package controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Citation;


public class CitationHelper {

	static EntityManagerFactory emfactory =	
		Persistence.createEntityManagerFactory("ResearchLog");
	
	public void insertCitation(Citation c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public	List<Citation> showAllCitations() {
		EntityManager	em	=	emfactory.createEntityManager();
		List<Citation> allItems = em.createQuery("SELECT i FROM Citation i").getResultList();
		return	allItems;
	}

	public void deleteCitation(Citation	toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Citation> typedQuery = em.createQuery(
				"select c from Citation c where c.refId = :selectedRefId", Citation.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedRefId", toDelete.getRefId());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Citation result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Citation searchForCitationByRefId(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Citation found = em.find(Citation.class, idToEdit);
		em.close();
		return found;
	}

	public void updateCitation(Citation toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

// Drew, do we have any need to search by anything other than refId? 
//
//	public List<Citation> searchForItemByStore(String storeName) {
//	// TODO modify for ResearchLog
//		EntityManager em = emfactory.createEntityManager();
//		em.getTransaction().begin();
//		TypedQuery<Citation> typedQuery = em.createQuery("select c from " +
//			"Citation c where c.store = :selectedStore",	Citation.class);
//		typedQuery.setParameter("selectedStore", storeName);
//		
//		List<Citation> foundItems = typedQuery.getResultList();
//		em.close();
//		return foundItems;
//	}
//
//	public List<Citation> searchForItemByItem(String itemName) {
//	// TODO modify for ResearchLog
//		EntityManager em	=	emfactory.createEntityManager();
//		em.getTransaction().begin();
//		TypedQuery<Citation>	typedQuery	=	em.createQuery("select c from " +
//		"Citation c where c.item = :selectedItem", Citation.class);
//		typedQuery.setParameter("selectedItem", itemName);
//		
//		List<Citation> foundItems = typedQuery.getResultList();
//		em.close();
//		return foundItems;
//	}
//
//
	
	public void cleanUp(){
		emfactory.close();
	}
	
}
