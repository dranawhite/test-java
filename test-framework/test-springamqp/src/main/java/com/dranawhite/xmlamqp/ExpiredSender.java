package com.dranawhite.xmlamqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liangyq
 * @version [1.0, 2018/4/16 15:29]
 */
public class ExpiredSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() throws InterruptedException {
		MessageProperties prop1 = new MessageProperties();
		prop1.setExpiration("10000");
		Message message1 = new Message("Hello World 2".getBytes(), prop1);
		rabbitTemplate.convertAndSend("TEST_RETRY_EXCHANGE", "TEST_RETRY_ROUTE_KEY", "Hello World1");

		Thread.sleep(5000);
		MessageProperties prop2 = new MessageProperties();
		prop2.setExpiration("10000");
		Message message2 = new Message("Hello World 1".getBytes(), prop2);
		rabbitTemplate.convertAndSend("TEST_RETRY_EXCHANGE", "TEST_RETRY_ROUTE_KEY", "Hello World2");
	}

}
