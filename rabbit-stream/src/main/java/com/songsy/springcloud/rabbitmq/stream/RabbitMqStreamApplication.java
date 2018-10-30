package com.songsy.springcloud.rabbitmq.stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author songsy
 * @Date 2018/10/30 10:32
 */
@SpringBootApplication
public class RabbitMqStreamApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RabbitMqStreamApplication.class).web(true).run(args);
    }

}
