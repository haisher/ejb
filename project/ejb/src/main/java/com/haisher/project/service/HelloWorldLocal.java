package com.haisher.project.service;

import javax.ejb.Local;

@Local
public interface HelloWorldLocal {

	public void printConsole(String value);

}
