package com.songsy.springcloud.eureka.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 服务器 集群启动
 * @author songshuiyang
 * @date 2018/8/15 12:52
 */
@SpringBootApplication
@EnableEurekaServer
public class Slave1ServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Slave1ServiceApplication.class).profiles("slave1").run(args);
    }
}
