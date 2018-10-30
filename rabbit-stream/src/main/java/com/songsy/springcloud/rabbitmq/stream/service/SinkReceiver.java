package com.songsy.springcloud.rabbitmq.stream.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * @EnableBinding 实现对消息通道Channel的绑定,Sink.class指绑定了Sink接口
 * @author songsy
 * @Date 2018/10/30 10:57
 */
@Component
@EnableBinding(Sink.class)
public class SinkReceiver {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @StreamListener(Sink.INPUT)
    public void receive (Object o) {
        logger.info("消费方Receiver收到消息: " + o.toString());
    }
}
