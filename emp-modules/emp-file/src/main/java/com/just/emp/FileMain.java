package com.just.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FileMain {
    public static void main(String[] args) {
        SpringApplication.run(FileMain.class,args);
    }
}
