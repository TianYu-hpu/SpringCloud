package cn.com.zenmaster.controller;

import cn.com.zenmaster.entity.po.Movie;
import cn.com.zenmaster.entity.vo.MoviePageVo;
import cn.com.zenmaster.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    private Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @GetMapping("/movie/{id:\\d+}")
    public Movie findMovie(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @PostMapping("/movie/save")
    public Movie save(@RequestBody Movie movie) {
        log.info("save movie{}", movie);
        return movieService.save(movie);
    }

    @PostMapping("/movie/update")
    public Movie update(@RequestBody Movie movie) {
        log.info("update movie{}", movie);
        return movieService.save(movie);
    }

    @DeleteMapping("/movie/{id:\\d+}")
    public boolean delete(@PathVariable long id) {
        return movieService.delete(id);
    }

    @PostMapping("/movie/list")
    public Page<Movie> list(@RequestBody MoviePageVo pageVo) {
        return movieService.page(pageVo);

    }

}
