package com.kaishengit.movieserviceconsumer.controller;

import com.kaishengit.movieserviceconsumer.pojo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id:\\d+}")
    public Movie helloMovie(@PathVariable Integer id) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("MOVIE-SERVICE-PROVIDER");
        String url = "http://" + serviceInstance.getHost() + ":"  + serviceInstance.getPort() + "/movie/" + id;
        return restTemplate.getForObject(url, Movie.class);
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
