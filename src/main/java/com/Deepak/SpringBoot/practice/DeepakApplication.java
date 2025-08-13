package com.Deepak.SpringBoot.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeepakApplication implements CommandLineRunner {
    @Autowired
    DataBase db;

    public static void main(String[] args) {
		SpringApplication.run(DeepakApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(db.getData());
    }
}
