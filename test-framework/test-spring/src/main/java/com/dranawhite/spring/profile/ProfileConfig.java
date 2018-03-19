package com.dranawhite.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author liangyq 2018/3/19
 */
@Configuration
public class ProfileConfig {

	@Bean
	@Profile("dev")
	public DeviceInfo devInfo() {
		return new DeviceInfo("DEV");
	}

	@Bean
	@Profile("pro")
	public DeviceInfo prodInfo() {
		return new DeviceInfo("PROD");
	}

}
