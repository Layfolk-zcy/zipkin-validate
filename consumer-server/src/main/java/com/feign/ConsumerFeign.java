package com.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 微服务底座平台
 * @version 2.0.0
 * @title: Feign
 * @projectName: erukeribbon
 * @description: feign
 * @date: 2022-08-30 14:55
 **/
/*@FeignClient(value = "skywalking-provider",url = "http://127.0.0.1:9091")*/
@FeignClient("provider-one-server")
public interface ConsumerFeign {

    @GetMapping("/provider/port")
    String getProviderFeignPort();
}
