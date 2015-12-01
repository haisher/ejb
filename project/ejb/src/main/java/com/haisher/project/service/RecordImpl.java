package com.haisher.project.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.haisher.project.dao.PersistenceService;
import com.haisher.project.domain.Record;

@Stateless
public class RecordImpl implements RecordLocal {

	@EJB
	private PersistenceService service;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Record record) {
		service.getEntityManager().persist(record);
	}

}
