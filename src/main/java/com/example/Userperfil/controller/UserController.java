package com.example.Userperfil.controller;


import com.example.Userperfil.Service.UserService;
import com.example.Userperfil.entity.User;
import com.example.Userperfil.model.Movie;
import com.example.Userperfil.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController

//@RequestMapping("/user")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getAll();

        if (users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){
        User user = userService.getUserById(id);

        if (user == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user){
        User userNew = userService.save(user);

        return ResponseEntity.ok(userNew);
    }

    @GetMapping("/music/{userId}")
    public ResponseEntity<List<Music>>  getMusic(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);

        if (user==null)
            return ResponseEntity.notFound().build();
        List<Music> music = userService.getMusic(userId);
        return ResponseEntity.ok(music);
    }


    @GetMapping("/movies/{userId}")
    public ResponseEntity<List<Movie>>  getMovie(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);

        if (user==null)
            return ResponseEntity.notFound().build();
        List<Movie> movies = userService.getMovie(userId);
        return ResponseEntity.ok(movies );
    }

    @PostMapping("/savermusic/{userId}")
    public  ResponseEntity<Music> saveMusic(@PathVariable("userId") int userId,  @RequestBody Music  music){
        if(userService.getUserById(userId) == null)
            return  ResponseEntity.notFound().build();
        Music newMusic = userService.saveMusic(userId, music);
        return ResponseEntity.ok(music);
    }

    @PostMapping("/savermovie/{userId}")
    public  ResponseEntity<Movie> saveMovie(@PathVariable("userId") int userId,  @RequestBody Movie  movie){
        if(userService.getUserById(userId) == null)
            return  ResponseEntity.notFound().build();
        Movie newMovie = userService.saveMovie(userId, movie);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("getAll/{userId}")
    public  ResponseEntity<Map<String, Object>> getUserAndPreferens(@PathVariable("userId") int userId){
        Map<String, Object> result = userService.getUserAndPreferens(userId);
        return ResponseEntity.ok(result);
    }


}
