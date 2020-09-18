package cn.com.zenmaster.movieserviceconsumer.service;

import cn.com.zenmaster.movieserviceconsumer.pojo.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public Movie findById(Integer id) {
        return restTemplate.getForObject("http://MOVIE-SERVICE-PROVIDER/movie/" + id, Movie.class);
    }

    public Movie findByIdFallback(Integer id) {
        return new Movie(-1, null, null);
    }

}
