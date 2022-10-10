package com.sunyard.staging.starter.swagger2.controller;

import com.sunyard.staging.starter.swagger2.bean.JsonSwagger2Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 微服务脚手架
 * @version 2.0.0
 * @title: Swagger2实现模块
 * @projectName staging-framework-starters
 * @description: TODO Swagger2对外接口
 * @date 2022/6/26 下午13:14
 */
@RestController
@RequestMapping("/staging-swagger2")
public class Swagger2Controller {

    @RequestMapping("/swagger2Info")
    public JsonSwagger2Data swagger2Info() {
        boolean isSuccess = true;
        return JsonSwagger2Data.buildSuccess(isSuccess);
    }

}