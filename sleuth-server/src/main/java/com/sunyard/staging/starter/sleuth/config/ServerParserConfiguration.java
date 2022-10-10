package com.sunyard.staging.starter.sleuth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.http.HttpRequestParser;
import org.springframework.cloud.sleuth.http.HttpResponseParser;
import org.springframework.cloud.sleuth.instrument.web.HttpServerRequestParser;
import org.springframework.cloud.sleuth.instrument.web.HttpServerResponseParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 微服务底座平台
 * @version 2.0.0
 * @title: ServerParserConfiguration
 * @projectName: erukeribbon
 * @description: http server span customize
 * @date: 2022-08-11 15:44
 **/

@Configuration(proxyBeanMethods = false)
public class ServerParserConfiguration {

    @Value("${spring.application.logyname:}")
    private String belLogy;
    @Value("${spring.application.appname:}")
    private String belApp;
    @Value("${server.port:}")
    private String port;
    @Value("${spring.application.name:}")
    private String belSer;
    @Value("${server.port:}")
    private String localEndPointPort;
    @Value("${eureka.instance.ip-address:}")
    private String localEndPointIp;

    @Bean(name = HttpServerRequestParser.NAME)
    HttpRequestParser myHttpClientRequestParser() {
        return (request, context, span) -> {
            span.name(request.method());
            span.tag("belLogy", belLogy);
            span.tag("belApp", belApp);
            span.tag("belSer", belSer);
            span.tag("serverName", belSer + port);
            span.tag("localEndPointIp", localEndPointIp);
            span.tag("localEndPointPort", localEndPointPort);

            String method = request.method();
            String path = request.path();
            span.tag("http.method", method);
            span.tag("http.path", path);
        };
    }

    @Bean(name = HttpServerResponseParser.NAME)
    HttpResponseParser myHttpClientResponseParser() {
        return (response, context, span) -> {
            span.tag("belLogy", belLogy);
            span.tag("belApp", belApp);
            span.tag("belSer", belSer);
            span.tag("serverName", belSer + port);
            span.tag("localEndPointIp", localEndPointIp);
            span.tag("localEndPointPort", localEndPointPort);

            String method = response.method();
            String path = response.request().path();
            span.tag("http.method", method);
            span.tag("http.path", path);
        };
    }
}
