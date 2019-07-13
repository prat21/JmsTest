package com.jms.test;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Consumer {

	public void consume() {
		try {
			InitialContext itx=new InitialContext();
			QueueConnectionFactory conFactory=(QueueConnectionFactory) itx.lookup("myConnectionFactory");
			QueueConnection qcon=conFactory.createQueueConnection();
			qcon.start();
			
			QueueSession session = qcon.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) itx.lookup("myQueue");
			QueueReceiver receiver = session.createReceiver(queue);
			
			Mylistener listener=new Mylistener();
			receiver.setMessageListener(listener);
			System.out.println("Waiting for messages....");
			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
