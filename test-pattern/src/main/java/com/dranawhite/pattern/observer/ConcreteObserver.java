package com.dranawhite.pattern.observer;

/**
 * @author liangyq 2018/3/20
 */
public class ConcreteObserver implements Observer {

	@Override
	public void update(String message) {
		System.out.println(message);
	}
}
