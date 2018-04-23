package com.dranawhite.hibernate.validate;


public class Person {
	@NotEmpty
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
}
