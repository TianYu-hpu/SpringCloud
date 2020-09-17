package com.kaishengit.movieserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServiceProviderApplication.class, args);
    }
}