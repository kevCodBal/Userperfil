package com.example.Userperfil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Movie {

    private String name;
    private String year;
    private String genero;
    private String img;
    private  int userId;
}
