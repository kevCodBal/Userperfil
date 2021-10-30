package com.example.Userperfil.Service;

import com.example.Userperfil.dao.UserDao;
import com.example.Userperfil.entity.User;
import com.example.Userperfil.feingClient.MovieFeingClient;
import com.example.Userperfil.feingClient.MusicFeignClient;
import com.example.Userperfil.model.Movie;
import com.example.Userperfil.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RestTemplate restTemplate;

   @Autowired
   MovieFeingClient movieFeingClient;

   @Autowired
   MusicFeignClient musicFeignClient;

    public List<User> getAll(){
        return userDao.findAll();
    }

    public User getUserById(int id){
        return userDao.findById(id).orElse(null);
    }

    public User save(User user){
        User userNew = userDao.save(user);
        return userNew;
    }


    public List<Music> getMusic(int userId){
        List<Music> music = restTemplate.getForObject("http://localhost:1030/music/byuser/"+ userId, List.class);
        return music;
    }


    public List<Movie> getMovie(int userId){
        List<Movie> movies = restTemplate.getForObject("http://localhost:1040/movie/byuser/"+ userId, List.class);
        return movies;
    }

    public Music saveMusic(int userId, Music music){
        music.setUserId(userId);
        Music musicNew = musicFeignClient.save(music);
        return musicNew;
    }


    public Movie saveMovie(int userId, Movie movie){
        movie.setUserId(userId);
        Movie movieNew = movieFeingClient.save(movie);
        return movieNew;
    }

    public Map<String, Object> getUserAndPreferens(int userId){
        Map<String,Object> result = new HashMap<>();

        User user= userDao.findById(userId).orElse(null);

        if (user == null){
            result.put("Mensaje", "No exite el usuario");
            return result;
        }

        result.put("User", user);
        List<Music> music = musicFeignClient.getMusica(userId);
        if (music.isEmpty())
            result.put("Music", "Este user no tiene agregado su musica");
        else
            result.put("Music", music);

        List<Movie> movies = movieFeingClient.getMovies(userId);
        if (movies.isEmpty())
            result.put("Movies", "Este user no tiene agregado sus peliculas");
        else
            result.put("Movies", movies);


        return result;


    }


}
