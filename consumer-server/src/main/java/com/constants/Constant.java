package com.constants;

/**
 * @author 微服务底座平台
 * @version 2.0.0
 * @title: constant
 * @projectName: sungrid-basicwork
 * @description: 常量
 * @date: 2022-07-05 10:31
 **/
public interface Constant {
    /**
     * HEADER 信息设置 开始
     */
    String HEADER_CONTENT_TYPE = "Content-Type";
    String HEADER_CONTENT_TYPE_VALUE = "application/json";
    String HEADER_ACCEPT = "Accept";
    String HEADER_ACCEPT_VALUE = "application/json";

    /*注册中心服务端 服务名称*/
    String REGISTER_CEN_APPLICATION_NAME = "sungrid-registercen";
    public static final Integer JSON_STATUSCODE_SUCCESS = 200;

}
