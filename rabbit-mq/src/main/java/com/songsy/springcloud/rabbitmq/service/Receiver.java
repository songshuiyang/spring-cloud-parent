package com.songsy.springcloud.rabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author songsy
 * @Date 2018/10/30 10:57
 */

@Component
@RabbitListener(queues = "hello")
public class Receiver {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String msg) {
        logger.info("消费方Receiver收到消息: " + msg);
    }
}
