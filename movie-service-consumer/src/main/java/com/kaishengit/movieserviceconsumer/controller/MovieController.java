package com.kaishengit.movieserviceconsumer.controller;

import com.kaishengit.movieserviceconsumer.client.MovieClient;
import com.kaishengit.movieserviceconsumer.pojo.Movie;
import com.kaishengit.movieserviceconsumer.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;


    //feign实现
    @Autowired
    private MovieClient movieClient;

    //@Autowired
    //private RestTemplate restTemplate;

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id:\\d+}")
    public Movie helloMovie(@PathVariable Integer id) {
        //loadBalancerClient实现效果
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("MOVIE-SERVICE-PROVIDER");
        String url = "http://" + serviceInstance.getHost() + ":"  + serviceInstance.getPort() + "/movie/" + id;*/

        //Ribbon实现效果
        /*String url = "http://MOVIE-SERVICE-PROVIDER/movie/" + id;
        return restTemplate.getForObject(url, Movie.class);*/

        //feign实现效果
        //return movieClient.findById(id);

        //hystrix实现
        return movieService.findById(id);
    }

    @PostMapping("/movie/new")
    public String save(String name, String actor) {
       return movieClient.save(name, actor);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
