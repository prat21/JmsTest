package com.jms.test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Mylistener implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		TextMessage txt=(TextMessage) msg;
		try {
			System.out.println("Message received by consumer: "+txt.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
