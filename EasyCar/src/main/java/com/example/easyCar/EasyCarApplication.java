package com.example.easyCar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EasyCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyCarApplication.class, args);
    }


    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper() ;
    }
}
