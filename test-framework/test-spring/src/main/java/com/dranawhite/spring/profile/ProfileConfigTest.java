package com.dranawhite.spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liangyq 2018/3/19
 */
public class ProfileConfigTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("pro");
		ctx.register(ProfileConfig.class);
		ctx.refresh();
		DeviceInfo deviceInfo = ctx.getBean(DeviceInfo.class);
		System.out.println(deviceInfo.getInfo());
	}

}
