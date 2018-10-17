package com.songsy.springcloud.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Eureka 服务调用者
 * @author songshuiyang
 * @date 2018/8/15 12:52
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsumerApplication.class).run(args);
    }
}
