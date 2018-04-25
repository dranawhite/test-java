package com.dranawhite.hibernate.validate;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Setter
@Getter
public class User {

	@Size(min = 1)
	private String firstname;

	@NotEmpty(message = "middlename may be empty")
	private String middlename;

	@NotEmpty(message = "lastname may be empty")
	private String lastname;

	@NotEmpty(message = "country may be empty")
	private String country;

	public static void main(String[] args) {
		User user = new User();
		user.setFirstname(" ");
		user.setMiddlename("midlename");
		user.setCountry("china");
		user.setLastname("liang");
		System.out.println(BeanValidateUtil.validate(user));
	}
}
