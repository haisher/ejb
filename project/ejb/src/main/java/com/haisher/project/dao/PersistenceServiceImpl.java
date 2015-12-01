
package com.haisher.project.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersistenceServiceImpl implements PersistenceService {

	@PersistenceContext(name = "test-ds")
	private EntityManager em;

	public EntityManager getEntityManager() {

		return em;
	}

}
