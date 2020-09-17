package com.kaishengit.movieserviceprovider.controller;

import com.kaishengit.movieserviceprovider.pojo.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private Logger log = LoggerFactory.getLogger(MovieController.class);

    @GetMapping("/movie/{id:\\d+}")
    public Movie findMovie(@PathVariable Integer id) {
        return new Movie(id, "大话西游", "周星驰");
    }

    @PostMapping("/movie/new")
    public String save(String name, String actor) {
        log.info("movie name:{}, movie actor{}", name, actor);
        return "success";
    }

}
