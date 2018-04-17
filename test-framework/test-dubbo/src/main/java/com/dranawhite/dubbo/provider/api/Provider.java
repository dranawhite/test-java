package com.dranawhite.dubbo.provider.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.dranawhite.dubbo.provider.DubboService;
import com.dranawhite.dubbo.provider.IDubboService;

import java.io.IOException;

/**
 * @author liangyq
 * @version [1.0, 2018/4/17 17:17]
 */
public class Provider {

	public static void main(String[] args) throws IOException {
		IDubboService dubboService = new DubboService();

		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("test-dubbo-provider");

		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("192.168.1.217:2181,192.168.1.218:2181,192.168.1.219:2181");
		registry.setProtocol("zookeeper");

		// 服务提供者协议配置
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		protocol.setPort(20880);

		// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

		// 服务提供者暴露服务配置
		// 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
		ServiceConfig<IDubboService> service = new ServiceConfig<>();
		service.setApplication(application);
		// 多个注册中心可以用setRegistries()
		service.setRegistry(registry);
		// 多个协议可以用setProtocols()
		service.setProtocol(protocol);
		service.setInterface(IDubboService.class);
		service.setRef(dubboService);
		service.setVersion("1.0.0");

		// 暴露及注册服务
		service.export();

		System.in.read();
	}
}
