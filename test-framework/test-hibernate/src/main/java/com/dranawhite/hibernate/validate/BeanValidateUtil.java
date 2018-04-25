package com.dranawhite.hibernate.validate;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author liangyq
 * @version [1.0, 2018/4/23 16:31]
 */
public final class BeanValidateUtil {

	private static Validator validator;

	static {
		ValidatorFactory validfactory = Validation.buildDefaultValidatorFactory();
		validator = validfactory.getValidator();
	}

	public static <T, G> boolean validate(T obj, Class<G> clz) {
		return validator.validate(obj, clz).size() == 0;
	}

	public static <T> boolean validate(T obj) {
		return validator.validate(obj).size() == 0;
	}

}
