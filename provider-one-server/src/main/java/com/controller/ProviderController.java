package com.controller;

import com.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/provider")
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProviderFeign providerFeign;

    @GetMapping("/port")
    public String getProviderPort() {
        return port;
    }

    @GetMapping("/providerTwo/port")
    public String getProviderTwoPort() {
        return providerFeign.getProviderTwoFeignPort();
    }

}
