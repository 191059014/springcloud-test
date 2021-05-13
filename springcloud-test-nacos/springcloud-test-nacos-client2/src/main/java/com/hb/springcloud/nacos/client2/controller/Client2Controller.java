package com.hb.springcloud.nacos.client2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 客户端2的controller
 *
 * @version v0.1, 2021/5/13 20:22, create by huangbiao.
 */
@RestController
@RequestMapping("/client2/controller")
public class Client2Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/method1")
    public Object method1() {
        return "this is method1 of Client2Controller";
    }

    @GetMapping("/invokeClient1Method1")
    public String invokeClient1Method1() {
        return restTemplate.getForObject("http://springcloud-test-nacos-client1/client1/controller/method1", String.class);
    }

}

    