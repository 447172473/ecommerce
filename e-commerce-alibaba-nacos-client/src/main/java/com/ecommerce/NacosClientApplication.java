package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <h1>Nacos Client 工程启动入口</h1>
 * */
@ServletComponentScan
@EnableCircuitBreaker   // 启动 Hystrix
@EnableFeignClients
@RefreshScope           // 刷新配置
@EnableDiscoveryClient  // 服务发现与服务注册
@SpringBootApplication  // spring boot 组合注解
public class NacosClientApplication {

    // args 命令行参数
    public static void main(String[] args) {

        SpringApplication.run(NacosClientApplication.class, args);
    }
}
