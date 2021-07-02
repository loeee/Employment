package com.just.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 authot ：赵文辉 郭欣华
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EmpEnterMain {
    public static void main(String[] args) {
        SpringApplication.run(EmpEnterMain.class,args);
    }
}
