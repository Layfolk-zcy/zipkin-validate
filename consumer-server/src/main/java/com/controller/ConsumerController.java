package com.controller;

import com.feign.ConsumerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 微服务底座平台
 * @version 2.0.0
 * @title: GatewayController
 * @projectName: erukeribbon
 * @description: controller
 * @date: 2022-08-30 14:09
 **/

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.test:not value}")
    private String test;

    @Autowired
    private ConsumerFeign consumerFeign;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/port")
    public String getConsumerPort() {
        return port + test;
    }

    @GetMapping("/provider/port")
    public String getConsumerFeignPort() {
        /*return restTemplate.getForObject("http://skywalking-provider/provider/port", String.class);*/
        return consumerFeign.getProviderFeignPort();
    }
}
