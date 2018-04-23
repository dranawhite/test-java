package com.dranawhite.hibernate.validate;

public interface Animal {

	@NotEmpty
	String getName();

	@NotEmpty
	String getOwnerName();
}
