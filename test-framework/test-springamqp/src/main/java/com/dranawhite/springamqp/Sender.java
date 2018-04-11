package com.dranawhite.springamqp;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SimpleMessageConverter;

/**
 * @author liangyq
 * @version [1.0, 2018/4/11 10:37]
 */
public class Sender {

	public static void main(String[] args) {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost("192.168.1.210");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("admin");

		// declare queue and exchange
		RabbitAdmin admin = new RabbitAdmin(connectionFactory);
		Queue queue = new Queue("test_queue", false, false, false);
		admin.declareQueue(queue);
		TopicExchange exchange = new TopicExchange("test_exchange");
		admin.declareExchange(exchange);
		admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with("test_topic"));

		// send something
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		SimpleMessageConverter messageConverter = new SimpleMessageConverter();
		messageConverter.setCreateMessageIds(true);
		template.setMessageConverter(messageConverter);
		template.convertAndSend("test_exchange", "test_topic", "Hello world!");
	}

}
