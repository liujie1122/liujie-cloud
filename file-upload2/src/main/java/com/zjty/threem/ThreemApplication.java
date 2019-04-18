package com.zjty.threem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
//@EnableDiscoveryClient
@SpringBootApplication
public class ThreemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreemApplication.class, args);
	}

	@Bean
	public RestTemplate initRestTemplate(){
		return new RestTemplate();
	}
}
