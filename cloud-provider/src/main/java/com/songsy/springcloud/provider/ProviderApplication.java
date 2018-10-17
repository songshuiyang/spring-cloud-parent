package com.songsy.springcloud.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Eureka 服务提供者
 * @author songshuiyang
 * @date 2018/8/15 12:52
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderApplication.class).run(args);
    }
}
