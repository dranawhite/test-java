package com.dranawhite.springamqp;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

import java.io.UnsupportedEncodingException;

/**
 * @author liangyq
 * @version [1.0, 2018/4/10 15:20]
 */
public class Receiver {

	public static void main(final String... args) throws Exception {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost("192.168.1.210");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("admin");

		// set up the listener and container
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		MessageListener listener = new MessageListener() {
			@Override
			public void onMessage(Message message) {
				try {
					String result = new String(message.getBody(), "UTF-8");
					System.out.println("Receive " + message.getBody());
					System.out.println("Receive Properties " + message.getMessageProperties());
					if (result.contains("!0")) {
						System.out.println("Receive 遭遇异常");
						throw new IllegalArgumentException();
					}
					System.out.println("Receive 业务处理");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		};
		MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
		container.setMessageListener(adapter);
		Queue queue = new Queue("test_queue", false, false, false);
		container.setQueues(queue);
		container.setConcurrentConsumers(3);
		container.setMaxConcurrentConsumers(3);
		container.setAcknowledgeMode(AcknowledgeMode.AUTO);
		container.start();
		Thread.sleep(100000);
		container.stop();
	}

}
