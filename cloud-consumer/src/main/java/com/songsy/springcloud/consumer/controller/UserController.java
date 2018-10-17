package com.songsy.springcloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.songsy.springcloud.consumer.service.HystirixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * 使用Riibbon实现的服务消费者
 * @author songshuiyang
 * @date 2018/8/15 13:50
 */
@Configuration
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HystirixService hystirixService;

    /**
     * 主要用来调用REST服务，本身并不具备调用分布式服务的能力，但通过LoadBalanced注解
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 客户端负债均衡测试
     * @return
     */
    @RequestMapping(value = "/userTest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String user() {
        RestTemplate restTpl = getRestTemplate();
        // 根据应用名称调用服务
        String json = restTpl.getForObject("http://eureka-provider/person/1", String.class);
        return json;
    }

    /**
     * 断路器测试： 关闭一个服务之后测试断路器
     * @return
     */
    @RequestMapping(value = "/circuitBreakerTest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String circuitBreakerTest() {
        return hystirixService.circuitBreaker();
    }

    /**
     * 断路器测试：模拟服务阻塞（长时间未响应）
     * @return
     */
    @RequestMapping(value = "/circuitBreakerTimeoutTest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String circuitBreakerTimeoutTest() throws Exception {
        int sleepTime = new Random().nextInt(6000);
        logger.info("睡眠时间" + sleepTime);
        Thread.sleep(sleepTime);
        return hystirixService.circuitBreaker();
    }
}
