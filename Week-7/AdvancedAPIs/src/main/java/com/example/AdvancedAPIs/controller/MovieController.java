package com.example.AdvancedAPIs.controller;

import com.example.AdvancedAPIs.model.Movie;
import com.example.AdvancedAPIs.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public Page<Movie> getAllMovies(@RequestParam(defaultValue = "0")int page,
                                    @RequestParam(defaultValue = "5")int size,
                                    @RequestParam(defaultValue = "id")String sortBy,
                                    @RequestParam(defaultValue = "asc")String order){
        return service.getAllMovies(page,size,sortBy,order);
    }
}
