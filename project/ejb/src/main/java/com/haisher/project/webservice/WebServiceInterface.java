package com.haisher.project.webservice;

import java.rmi.Remote;

public interface WebServiceInterface extends Remote {

	public void invokeService(String value);

}
