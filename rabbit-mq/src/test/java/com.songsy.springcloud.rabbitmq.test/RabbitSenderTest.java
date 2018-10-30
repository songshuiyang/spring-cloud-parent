package com.songsy.springcloud.rabbitmq.test;

import com.songsy.springcloud.rabbitmq.RabbitMqApplication;
import com.songsy.springcloud.rabbitmq.service.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author songsy
 * @Date 2018/10/30 11:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqApplication.class)
public class RabbitSenderTest {

    @Autowired
    private Sender sender;


    @Test
    public void hello () throws Exception {
        for (int i= 0; i< 10; i++) {
            sender.send();
        }
    }
}
