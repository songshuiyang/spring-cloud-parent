package com.songsy.springcloud.consumer.controller;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author songshuiyang
 * @date 2018/8/15 13:50
 */
@Configuration
@RestController
public class UserController {
    /**
     * 主要用来调用REST服务，本身并不具备调用分布式服务的能力，但通过LoadBalanced注解
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/router", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String router() {
        RestTemplate restTpl = getRestTemplate();
        // 根据应用名称调用服务
        String json = restTpl.getForObject("http://eureka-provider/person/1", String.class);
        return json;
    }
}
