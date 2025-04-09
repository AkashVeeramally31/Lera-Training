package com.example.AdvancedAPIs.service;

import com.example.AdvancedAPIs.model.Movie;
import com.example.AdvancedAPIs.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepo repo;


    public Page<Movie> getAllMovies(int page, int size, String sortBy, String order) {
        Sort sort=order.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page,size,sort);
        return repo.findAll(pageable);
    }
}
