package com.hb.springcloud.nacos.client1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * 测试
 *
 * @version v0.1, 2021/5/12 22:47, create by huangbiao.
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${client.createBy}")
    private String createBy;

    @PostConstruct
    public void init() {
        System.out.println("client.createBy=" + createBy);
    }

    @GetMapping("/getCreateBy")
    public Object getCreateBy() {
        return "client.createBy=" + createBy;
    }


}

    