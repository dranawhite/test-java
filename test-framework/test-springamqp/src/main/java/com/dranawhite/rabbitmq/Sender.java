package com.dranawhite.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author liangyq
 * @version [1.0, 2018/4/11 10:16]
 */
public class Sender {

	private final static String QUEUE_NAME = "test_queue";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.1.210");
		factory.setPort(5672);
		factory.setUsername("admin");
		factory.setPassword("admin");

		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello World!";
		channel.queueBind("test_queue", "test_exchange", "test_topic");
		for (int i = 0; i < 10; i++) {
			String body = message + i;
			channel.basicPublish("test_exchange", "test_topic", null, body.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + body + "'");
		}

		channel.close();
		connection.close();
	}
}
