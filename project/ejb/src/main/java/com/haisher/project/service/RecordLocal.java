package com.haisher.project.service;

import javax.ejb.Local;

import com.haisher.project.domain.Record;

@Local
public interface RecordLocal {

	public void save(Record record);
}
