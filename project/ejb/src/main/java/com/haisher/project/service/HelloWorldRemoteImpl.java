package com.haisher.project.service;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldRemoteImpl implements HelloWorldRemote {

	private static final long serialVersionUID = -4507515590135243065L;

	@Override
	public void sayHello(String value) {
		System.out.println("Received remote value: " + value);

	}

}
