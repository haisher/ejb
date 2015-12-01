package com.haisher.project.interceptor;

import javax.annotation.PostConstruct;

public class GenericInterceptors {

	@PostConstruct
	public void postConstruct() {
		System.out.println("Do something on the postConstruct");
	}
}
