package com.haisher.project.service;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldImpl implements HelloWorldLocal {

	@Override
	public void printConsole(String value) {

		System.out.println("Value from screen: " + value);
	}
}
