package com.songsy.springcloud.provider.controller;

import com.songsy.springcloud.provider.domain.Person;
import com.songsy.springcloud.provider.utils.IpConfigurationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songshuiyang
 * @date 2018/10/22 22:03
 */
@RestController
public class FeignController {

    @GetMapping("getPersonName")
    public String getPersonName() {
        return "songsy" + "端口：" + IpConfigurationUtils.getPort();
    }

    @GetMapping("getPerson")
    public Person getPerson(){
        Person person = new Person();
        person.setName("songsy" + "端口：" + IpConfigurationUtils.getPort());
        person.setId(1);
        person.setAge(88);
        return person;
    }

}
