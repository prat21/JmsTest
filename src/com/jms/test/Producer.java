package com.jms.test;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException; 

public class Producer implements Runnable{

	/*public void produce() {
		try {
			InitialContext itx=new InitialContext();
			QueueConnectionFactory conFactory=(QueueConnectionFactory) itx.lookup("myConnectionFactory");
			QueueConnection qcon=conFactory.createQueueConnection();
			qcon.start();
			
			QueueSession session = qcon.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) itx.lookup("myQueue");
			QueueSender sender = session.createSender(queue);
			for(int i=0;i<10;i++){
				TextMessage message = session.createTextMessage();
				message.setText("This is from pratik "+i);
				sender.send(message);
				System.out.println("Producer has sent the Message "+message.getText()+" in Q");
			}
			
			
			qcon.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}*/

	@Override
	public void run() {
		try {
			InitialContext itx=new InitialContext();
			QueueConnectionFactory conFactory=(QueueConnectionFactory) itx.lookup("myConnectionFactory");
			QueueConnection qcon=conFactory.createQueueConnection();
			qcon.start();
			
			QueueSession session = qcon.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) itx.lookup("myQueue");
			QueueSender sender = session.createSender(queue);
			for(int i=0;i<100;i++){
				TextMessage message = session.createTextMessage();
				message.setText("This is from pratik "+i);
				sender.send(message);
				System.out.println("Producer has sent the Message "+message.getText()+" in Q");
			}
			
			
			qcon.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
