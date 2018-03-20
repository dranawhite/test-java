package com.dranawhite.pattern.observer;

/**
 * @author liangyq 2018/3/20
 */
public class Main {

	public static void main(String[] args) {
		Subject subject = new ConcreteSubject();
		subject.attach(new ConcreteObserver());
		subject.notify("开饭啦！");
	}

}
