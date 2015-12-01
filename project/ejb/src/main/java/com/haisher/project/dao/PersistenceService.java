
package com.haisher.project.dao;

import javax.ejb.Local;
import javax.persistence.EntityManager;

@Local
public interface PersistenceService {

	public EntityManager getEntityManager();
}
