package com.songsy.springcloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songshuiyang
 * @date 2018/10/25 22:08
 */
@RestController
@RefreshScope
public class ClientController {

//    @Value("${name}")
    private String name;

    @GetMapping
    public String getName () {
        return name;
    }
}
