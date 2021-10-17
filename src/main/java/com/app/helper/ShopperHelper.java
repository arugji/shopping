package com.app.helper;

import java.util.List;

import javax.persistence.EntityManager;

import com.app.entity.Shopper;
import com.app.util.EntityManagerUtil;

public class ShopperHelper {

	public void insertShopper(Shopper obj) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		entityManager.refresh(obj);
		entityManager.close();
	}

	public List<Shopper> showAllShoppers() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Shopper> allShoppers = (List<Shopper>) entityManager.createQuery("SELECT S FROM Shopper S")
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return allShoppers;
	}

	public Shopper searchById(long id) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		Shopper obj = entityManager.find(Shopper.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return obj;
	}

	public void updateShopper(Shopper obj) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void deleteShopperHelper(Shopper obj) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		if (!entityManager.contains(obj)) {
			obj = entityManager.merge(obj);
		}
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
