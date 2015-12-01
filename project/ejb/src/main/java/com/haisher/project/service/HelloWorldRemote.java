package com.haisher.project.service;

import java.io.Serializable;

import javax.ejb.Remote;

@Remote
public interface HelloWorldRemote extends Serializable {

	public void sayHello(String value);

}
