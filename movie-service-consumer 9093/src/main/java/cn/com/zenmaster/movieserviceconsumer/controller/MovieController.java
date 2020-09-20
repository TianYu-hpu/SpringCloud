package cn.com.zenmaster.movieserviceconsumer.controller;

import cn.com.zenmaster.movieserviceconsumer.client.MovieClient;
import cn.com.zenmaster.movieserviceconsumer.pojo.Movie;
import cn.com.zenmaster.movieserviceconsumer.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/movie/save")
    public String save(@RequestBody Movie movie) {
        return movieClient.save(movie);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
