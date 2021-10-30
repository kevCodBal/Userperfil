package com.example.Userperfil.feingClient;


import com.example.Userperfil.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@FeignClient(name= "movie-service", url = "http://localhost:1040")
@RequestMapping("/movie")
public interface MovieFeingClient {


    @PostMapping()
    Movie save(@RequestBody Movie movie);


    @GetMapping("/byuser/{userId}")
    List<Movie> getMovies(@PathVariable("userId") int userId);

}
