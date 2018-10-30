package com.songsy.springcloud.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author songsy
 * @Date 2018/10/30 10:59
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue () {
        return new Queue("hello");
    }
}
