package com.amoxuk;

/**
 * Created by Misty-Rain on 2019/5/26.
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {


        SpringApplication.run(Application.class, args);
    }

}