package com.dranawhite.xmlamqp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * RabbitMQ私信队列
 *
 * @author liangyq
 * @version [1.0, 2018/4/11 19:52]
 */
public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-mq.xml");
		Sender sender = (Sender) ctx.getBean("sender");
		sender.send();
	}

}
