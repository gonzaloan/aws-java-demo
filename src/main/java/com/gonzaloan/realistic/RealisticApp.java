package com.gonzaloan.realistic;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealisticApp {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        org.springframework.boot.SpringApplication.run(RealisticApp.class, args);
    }
}
