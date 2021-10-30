package com.example.Userperfil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserperfilApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserperfilApplication.class, args);
	}

}
