package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 微服务底座平台
 * @version 2.0.0
 * @title: SkywalkingConsumerApplication
 * @projectName: erukeribbon
 * @description: entrance
 * @date: 2022-08-30 14:06
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
