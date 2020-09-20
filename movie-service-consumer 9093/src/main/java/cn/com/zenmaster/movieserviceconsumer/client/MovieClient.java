package cn.com.zenmaster.movieserviceconsumer.client;

import cn.com.zenmaster.movieserviceconsumer.pojo.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "MOVIE-SERVICE-PROVIDER")
@Component
public interface MovieClient {

    @GetMapping("/movie/{id}")
    Movie findById(@PathVariable(name = "id") Integer id);

    @PostMapping("/movie/save")
    String save(@RequestBody Movie movie);

}
