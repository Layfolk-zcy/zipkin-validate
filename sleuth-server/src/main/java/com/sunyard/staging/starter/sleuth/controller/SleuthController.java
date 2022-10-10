package com.sunyard.staging.starter.sleuth.controller;

import com.sunyard.staging.starter.sleuth.bean.JsonSleuthData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 微服务脚手架
 * @version 2.0.0
 * @title: SpringCloud链路追踪实现模块
 * @projectName staging-framework-starters
 * @description: TODO SpringCloud链路追踪对外接口
 * @date 2022/6/26 下午13:14
 */
@RestController
@RequestMapping("/staging-sleuth")
public class SleuthController {

    @RequestMapping("/sleuthInfo")
    public JsonSleuthData sleuthInfo() {
        boolean isSuccess = true;
        return JsonSleuthData.buildSuccess(isSuccess);
    }

}