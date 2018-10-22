package com.songsy.springcloud.feign.service;

import com.songsy.springcloud.feign.domain.Person;
import com.songsy.springcloud.feign.hystrix.PersonHystrixFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * name 为服务提供者 application-name，fallback 指定服务接口的断路器实现方法
 * @author songshuiyang
 * @date 2018/10/22 21:53
 */
@FeignClient(name = "eureka-provider", fallback = PersonHystrixFallback.class)
public interface PersonService {

    @RequestMapping("getPersonName")
    String getPersonName();

    @RequestMapping("getPerson")
    Person getPerson();

}
