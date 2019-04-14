package com.liujie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAutoConfiguration
//@EnableEurekaClient
@SpringBootApplication
public class AdminClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminClientApplication.class, args);
	}

}
