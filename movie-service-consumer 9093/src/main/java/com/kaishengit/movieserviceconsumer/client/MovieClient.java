package com.kaishengit.movieserviceconsumer.client;

import com.kaishengit.movieserviceconsumer.pojo.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MOVIE-SERVICE-PROVIDER")
@Component
public interface MovieClient {

    @GetMapping("/movie/{id}")
    Movie findById(@PathVariable(name = "id") Integer id);

    @PostMapping("/movie/new")
    String save(@RequestParam(name = "name") String name, @RequestParam(name = "actor") String actor);

}
