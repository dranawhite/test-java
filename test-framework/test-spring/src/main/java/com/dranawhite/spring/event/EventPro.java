package com.dranawhite.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liangyq 2018/3/19
 */
public class EventPro {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyEventConfig.class);
		ctx.publishEvent(new MyEvent("EventPro", "HelloWorld"));
		ctx.close();
	}

}
