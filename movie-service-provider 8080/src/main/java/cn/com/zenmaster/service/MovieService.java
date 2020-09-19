package cn.com.zenmaster.service;

import cn.com.zenmaster.entity.po.Movie;
import cn.com.zenmaster.entity.vo.MoviePageVo;
import cn.com.zenmaster.repository.MovieRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Cacheable(value = "movie", key = "#p0")
    public Movie getById(Long id) {
        return movieRepository.getOne(id);
    }

    @CachePut(value = "movie", key = "#result.getId()")
    public Movie save(Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }

    @CacheEvict(value = "movie", key = "#p0")
    public boolean delete(long id) {
        if(movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<Movie> page(MoviePageVo pageVo) {
        Pageable page = PageRequest.of(pageVo.getPageNum(), pageVo.getPageSize());
        Movie movie = new Movie();
        movie.setActor(pageVo.getActor());
        movie.setName(pageVo.getName());
        Example<Movie> example = Example.of(movie);
        return movieRepository.findAll(example, page);
    }
}
