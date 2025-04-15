package com.example.baitapnhomoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.baitapnhomoop.repository")
@EnableJpaAuditing
@AutoConfiguration
public class BaiTapOopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaiTapOopApplication.class, args);
    }

}
