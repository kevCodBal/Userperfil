package com.example.Userperfil.feingClient;


import com.example.Userperfil.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@FeignClient(name = "music-service", url = "http://localhost:1030")
@RequestMapping("/music")

public interface MusicFeignClient {


    @PostMapping()
    Music save(@RequestBody Music music);


    @GetMapping("/byuser/{userId}")
    List<Music> getMusica(@PathVariable("userId") int userId);
}
