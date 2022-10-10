package com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 微服务底座平台
 * @version 2.0.0
 * @title: SshProperties
 * @projectName: sungrid-basicwork
 * @description: TODO 仓库服务器的ssh连接配置
 * @date: 2022-06-24 15:37
 **/
@ConfigurationProperties(prefix = "ssh")
@Component
public class SshProperties {

    /*ssh连接用户名*/
    private String user;
    /*ssh连接密码*/
    private String password;
    /*ssh连接服务器ip*/
    private String ip;
    /*ssh连接服务端口*/
    private int port;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
