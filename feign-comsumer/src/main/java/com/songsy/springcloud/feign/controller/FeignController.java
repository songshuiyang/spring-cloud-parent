package com.songsy.springcloud.feign.controller;

import com.songsy.springcloud.feign.domain.Person;
import com.songsy.springcloud.feign.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songshuiyang
 * @date 2018/10/22 21:59
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private PersonService personService;


    @GetMapping("getPersonName")
    public String getPersonName() {
        return personService.getPersonName();
    }

    @GetMapping("getPerson")
    public Person getPerson(){
        return personService.getPerson();
    }

}
