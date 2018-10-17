package com.songsy.springcloud.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Eureka 服务提供者 集群2
 * @author songshuiyang
 * @date 2018/8/15 12:52
 */
@SpringBootApplication
@EnableEurekaClient
public class Slave2ProviderApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Slave1ProviderApplication.class).properties("server.port=9023").run(args);
    }
}
