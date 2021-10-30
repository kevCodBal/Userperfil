package com.example.Userperfil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Music {


    private String name;
    private String artist;
    private String urlImg;
    private  int userId;
}
