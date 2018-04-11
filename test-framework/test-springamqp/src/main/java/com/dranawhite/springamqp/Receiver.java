package com.dranawhite.springamqp;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

import java.util.Date;

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
		Object listener = new Object() {
			public void handleMessage(String foo) {
				System.out.println(foo);
			}
		};
		MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
		container.setMessageListener(adapter);
		container.setQueueNames("test_queue");
		container.start();
		Thread.sleep(1000);
		container.stop();
	}

}
