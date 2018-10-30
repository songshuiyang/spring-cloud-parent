package com.songsy.springcloud.rabbitmq;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author songsy
 * @Date 2018/10/30 10:32
 */
@SpringBootApplication
public class RabbitMqApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RabbitMqApplication.class).web(true).run(args);
    }

}
