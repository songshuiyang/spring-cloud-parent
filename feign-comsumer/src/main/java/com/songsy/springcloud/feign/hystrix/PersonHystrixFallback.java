package com.songsy.springcloud.feign.hystrix;

import com.songsy.springcloud.feign.domain.Person;
import com.songsy.springcloud.feign.service.PersonService;
import org.springframework.stereotype.Component;

/**
 * Hystrix服务降级 每一个服务接口的断路器实现就是实现类中重写函数的实现
 * @author songshuiyang
 * @date 2018/10/22 22:26
 */
@Component
public class PersonHystrixFallback implements PersonService {

    @Override
    public String getPersonName() {
        return "HystrixFallbackService ERROR";
    }

    @Override
    public Person getPerson() {
        return new Person(0,"HystrixFallbackService ERROR",88);
    }
}
