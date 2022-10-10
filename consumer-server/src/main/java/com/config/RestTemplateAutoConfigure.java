package com.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author 微服务底座平台
 * @version 2.0.0
 * @title: RestTemplateAutoConfigure
 * @projectName sungrid-framework
 * @description: TODO rest连接池装载配置类
 * @date 2022/2/22 下午13:14
 */

@Configuration //不开启当前RestTemplate自动配置类
@EnableConfigurationProperties(RestTemplateProperties.class)
public class RestTemplateAutoConfigure {

    @Autowired
    private RestTemplateProperties restTemplateProperties;

    /*LoadBalanced --请求url时将服务ip换为服务名否则在负载时将无法识别ip进行负载到对应的服务*/
    /*@LoadBalanced*/
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        /**设置RestTemplate的请求连接池工厂*/
        restTemplate.setRequestFactory(httpRequestFactory());
        return restTemplate;
    }

    /**
     * httpclient 实现的ClientHttpRequestFactory
     */
    @Bean
    public ClientHttpRequestFactory httpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }

    /**
     * 使用连接池的 httpclient
     */
    @Bean
    public HttpClient httpClient() {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        // 最大链接数
        connectionManager.setMaxTotal(restTemplateProperties.getMaxTotal());
        // 同路由并发数20
        connectionManager.setDefaultMaxPerRoute(restTemplateProperties.getMaxPerRoute());
        RequestConfig requestConfig = RequestConfig.custom()
                // 读超时
                .setSocketTimeout(restTemplateProperties.getReadTimeout())
                // 链接超时
                .setConnectTimeout(restTemplateProperties.getConnectTimeout())
                // 链接不够用的等待时间
                .setConnectionRequestTimeout(restTemplateProperties.getReadTimeout())
                .build();
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(3, true))
                .build();
    }
}
