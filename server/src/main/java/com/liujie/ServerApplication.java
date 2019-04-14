package com.liujie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAutoConfiguration
//@EnableEurekaClient
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		/**
		 * Springboot整合Elasticsearch 在项目启动前设置一下的属性，防止报错
		 * 当单独整合Elasticsearch不会i报错，但是在整合redis后汇报错：
		 * nested exception is java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
		 * 需要加上如下配置
		 * 		System.setProperty("es.set.netty.runtime.available.processors", "false");
		 * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
		 */
		System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(ServerApplication.class, args);
	}

}
