package com.haisher.project.remote.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.haisher.project.service.HelloWorldRemote;

/**
 * 
 * Remember to manually add the jar ${JBOSS_HOME}/client/jbossall-client.jar on 'Java Build Path/Libraries' from Eclipse.
 * Test with running jboss or otherwise you will get an exception when looking up for the remote interface.
 * 
 */
public class RemoteClient {

	private static void accessRemoteImplementation(String value) {

		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");

		try {
			Context ctx = new InitialContext(properties);

			HelloWorldRemote service = (HelloWorldRemote) ctx.lookup("project/HelloWorldRemoteImpl/remote");
			service.sayHello(value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		accessRemoteImplementation("test");
	}
}
