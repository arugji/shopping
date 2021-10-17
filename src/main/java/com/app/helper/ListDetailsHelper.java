package com.app.helper;

import java.util.List;

import javax.persistence.EntityManager;

import com.app.entity.ListDetails;
import com.app.util.EntityManagerUtil;

public class ListDetailsHelper {

	public void insertListDetails(ListDetails obj) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		entityManager.refresh(obj);
		entityManager.close();
	}

	public List<ListDetails> showAllList() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<ListDetails> listDetails = (List<ListDetails>) entityManager.createQuery("SELECT S FROM ListDetails S")
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return listDetails;
	}
}
