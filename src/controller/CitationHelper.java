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
	
	public void insertItem(Citation c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public	List<Citation> showAllItems() {
		EntityManager	em	=	emfactory.createEntityManager();
		List<Citation> allItems = em.createQuery("SELECT i FROM Citation i").getResultList();
		return	allItems;
		}

	public void deleteItem(Citation	toDelete) {		// TODO modify for ResearchLog
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Citation> typedQuery = em.createQuery("select c from " +
			"Citation c where c.store = :selectedStore and c.item = :" +
			"selectedItem", Citation.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedStore", toDelete.getStore());
		typedQuery.setParameter("selectedItem", toDelete.getItem());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Citation result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Citation searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Citation found = em.find(Citation.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Citation toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Citation> searchForItemByStore(String storeName) {
	// TODO modify for ResearchLog
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Citation> typedQuery = em.createQuery("select c from " +
			"Citation c where c.store = :selectedStore",	Citation.class);
		typedQuery.setParameter("selectedStore", storeName);
		
		List<Citation> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Citation> searchForItemByItem(String itemName) {
	// TODO modify for ResearchLog
		EntityManager em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Citation>	typedQuery	=	em.createQuery("select c from " +
		"Citation c where c.item = :selectedItem", Citation.class);
		typedQuery.setParameter("selectedItem", itemName);
		
		List<Citation> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
	
}
