package com.kaishengit.movieserviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceConsumerApplication.class, args);
	}
}
