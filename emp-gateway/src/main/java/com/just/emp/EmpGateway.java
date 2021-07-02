package com.just.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * author ： 赵文辉
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EmpGateway {
    public static void main(String[] args) {
        SpringApplication.run(EmpGateway.class,args);
    }
}
