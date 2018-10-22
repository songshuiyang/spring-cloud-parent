package com.songsy.springcloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author songshuiyang
 * @date 2018/10/22 21:50
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignAppliacation {
    public static void main(String[] args) {
        SpringApplication.run(FeignAppliacation.class,args);
    }
}
