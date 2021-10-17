package com.app.helper;

import java.util.List;

import javax.persistence.EntityManager;

import com.app.entity.ListItem;
import com.app.util.EntityManagerUtil;

public class ListItemHelper {

	public List<ListItem> showAllList() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<ListItem> listDetails = (List<ListItem>) entityManager.createQuery("SELECT S FROM ListItem S")
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return listDetails;
	}

	public ListItem searchById(long id) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		ListItem obj = entityManager.find(ListItem.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return obj;
	}
}
