package com.dranawhite.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * RabbitMQ原生代码
 *
 * @author liangyq
 * @version [1.0, 2018/4/11 9:57]
 */
public class Receiver {

	private final static String QUEUE_NAME = "test_queue";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.1.210");
		factory.setPort(5672);
		factory.setUsername("admin");
		factory.setPassword("admin");

		Connection connection = factory.newConnection();
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		Receiver receiver = new Receiver();
		final Channel channelA = connection.createChannel();
		RabbitConsumer consumerA = receiver.new RabbitConsumer(channelA, "A");
		final Channel channelB = connection.createChannel();
		RabbitConsumer consumerB = receiver.new RabbitConsumer(channelB, "B");
		consumerA.consume();
//		consumerB.consume();
//		Thread retry = new Thread(new Retry(channelA));
//		retry.start();
	}

	class RabbitConsumer extends DefaultConsumer {

		private Channel channel;

		private String name;

		public RabbitConsumer(Channel channel, String name) throws IOException {
			super(channel);
			this.channel = channel;
			this.name = name;
			channel.basicQos(1);
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		}

		@Override
		public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
				throws IOException {
			String message = new String(body, "UTF-8");
			System.out.println(" [" + name + "] Received '" + message + "'" + "; TAG=" + envelope.getDeliveryTag());
			if (true) {
				System.out.println(" [" + name + "] Received 遭遇异常!");
				throw new IllegalArgumentException();
			}
			System.out.println(" [" + name + "] Received 业务操作!");
			channel.basicAck(envelope.getDeliveryTag(), false);
		}

		public void consume() throws IOException {
			channel.basicConsume(QUEUE_NAME, false, this);
		}
	}
}

class Retry implements Runnable {

	private Channel channel;

	public Retry(Channel channel) {
		this.channel = channel;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
			channel.basicRecover(false);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
