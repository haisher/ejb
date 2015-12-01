package com.haisher.project.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/TestQueue") })
public class BlogQueueConsumer implements MessageListener {

	@Override
	public void onMessage(Message message) {

		TextMessage textMessage = (TextMessage) message;

		try {
			System.out.println("Received message: " + textMessage.getText());
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

	@AroundInvoke
	public Object interceptador(InvocationContext ctx) throws Exception {

		System.out.println("intercepting Queue");
		Object flow = ctx.proceed();
		System.out.println("Aftermost interception");

		return flow;
	}

}
