package com.songsy.springcloud.zuul;

import com.songsy.springcloud.zuul.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author songshuiyang
 * @date 2018/10/23 20:29
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

    @Bean
    public AccessFilter accessFilter () {
        return new AccessFilter();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }


}
