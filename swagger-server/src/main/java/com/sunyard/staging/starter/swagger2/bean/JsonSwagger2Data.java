package com.sunyard.staging.starter.swagger2.bean;

import org.springframework.stereotype.Component;

/**
 * @author 微服务脚手架
 * @version 2.0.0
 * @title: Swagger2实现模块
 * @projectName staging-framework-starters
 * @description: TODO 返回统一的json数据格式
 * @date 2022/6/26 下午13:14
 */
@Component
public class JsonSwagger2Data {

    //TODO 表示请求成功或者失败的响应码
    private Integer code;

    //TODO 请求成功或者失败的信息描述
    private String msg;

    //TODO 响应的具体数据
    private Object data;

    /**
     * 构造函数
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public JsonSwagger2Data(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造函数
     *
     * @return
     */
    public JsonSwagger2Data() {
    }

    /**
     * 需要向外部暴露响应成功以及失败的信息--响应成功
     *
     * @param data
     * @return JsonData
     */
    public static JsonSwagger2Data buildSuccess(Object data) {
        return new JsonSwagger2Data(200, "响应成功", data);
    }

    /**
     * 需要向外部暴露响应成功以及失败的信息--响应成功
     *
     * @param msg
     * @return JsonData
     */
    public static JsonSwagger2Data buildSuccess(String msg) {
        return new JsonSwagger2Data(200, "响应成功", msg);
    }

    /**
     * 需要向外部暴露响应成功以及失败的信息--响应失败
     *
     * @return JsonData
     */
    public static JsonSwagger2Data buildFail() {
        return new JsonSwagger2Data(-100, "响应失败", null);
    }

    /**
     * 需要向外部暴露响应成功以及失败的信息--响应失败
     *
     * @param msg
     * @return JsonData
     */
    public static JsonSwagger2Data buildFail(String msg) {
        return new JsonSwagger2Data(-100, msg, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
