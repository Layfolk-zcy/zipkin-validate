package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 微服务底座平台
 * @version 2.0.0
 * @title: GatewayController
 * @projectName: erukeribbon
 * @description: controller
 * @date: 2022-08-30 14:09
 **/

@RestController
@RequestMapping("/eurekas")
public class EurekasController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    public String getEurekaPort() {
        return port;
    }
}
