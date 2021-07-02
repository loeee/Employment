package com.just.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * author ： 周鑫
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EmpAuthMain {
    public static void main(String[] args) {
        SpringApplication.run(EmpAuthMain.class,args);
    }
}
