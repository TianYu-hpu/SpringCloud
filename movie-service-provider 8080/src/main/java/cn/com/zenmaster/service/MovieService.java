package cn.com.zenmaster.service;

import cn.com.zenmaster.entity.po.Movie;
import cn.com.zenmaster.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Cacheable(value = "movie", key = "#p0")
    public Movie getById(Long id) {
        return movieRepository.getOne(id);
    }

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

}
