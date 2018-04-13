package com.dranawhite.xmlamqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liangyq
 * @version [1.0, 2018/4/11 19:51]
 */
public class Sender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		rabbitTemplate.convertAndSend("TEST_BUSINESS_EXCHANGE", "TEST_BUSINESS_ROUTE_KEY", "Hello World!");
	}

}
