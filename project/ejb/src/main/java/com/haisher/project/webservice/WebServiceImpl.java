package com.haisher.project.webservice;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@Stateless

@WebService(name = "WebServiceImpl", serviceName = "WebServiceImplService",
targetNamespace = "http://webservice.tests.haisher.com", portName = "WebServiceImplPort")

@SOAPBinding(style = Style.RPC)
public class WebServiceImpl implements WebServiceInterface {

	@Override
	@WebMethod
	public void invokeService(String value) {
		System.out.println("WebService successfuly invoked.");
		System.out.println("Webservice value: " + value);
	}

}
