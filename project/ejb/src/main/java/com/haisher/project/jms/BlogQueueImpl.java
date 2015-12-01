package com.haisher.project.jms;

import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

@Stateless
public class BlogQueueImpl implements BlogQueueLocal {

	private static final String QUEUE = "queue/TestQueue";
	private static final String CONNECTION_FACTORY = "ConnectionFactory";

	@Override
	public void sendMessage(String msg) {

		Connection conn = null;
		Session session = null;

		try {
			Context ctx = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) ctx.lookup(CONNECTION_FACTORY);

			conn = factory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Queue queue = (Queue) ctx.lookup(QUEUE);

			MessageProducer publisher = session.createProducer(queue);

			TextMessage message = session.createTextMessage(msg);
			publisher.send(message);

			System.out.println("Scheduled.");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				session.close();
				conn.close();
			} catch (JMSException e) {
				throw new RuntimeException(e);
			}
		}

	}

}
