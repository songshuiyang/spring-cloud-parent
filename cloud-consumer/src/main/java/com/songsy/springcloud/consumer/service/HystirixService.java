package com.songsy.springcloud.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author songshuiyang
 * @date 2018/10/17 22:47
 */
@Service
public class HystirixService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String circuitBreaker() {
        // 根据应用名称调用服务
        String json = restTemplate.getForObject("http://eureka-provider/person/1", String.class);
        return json;
    }

    /**
     * 定义服务降级处理逻辑
     * @return
     */
    private String fallback () {
        return "熔断器返回的信息";
    }
}
