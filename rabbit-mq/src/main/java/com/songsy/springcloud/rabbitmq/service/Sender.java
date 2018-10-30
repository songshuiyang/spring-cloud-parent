package com.songsy.springcloud.rabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author songsy
 * @Date 2018/10/30 10:36
 */
@Component
public class Sender {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "songsy" + new Date();
        logger.info("生产者Sender 开始发送消息 " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
