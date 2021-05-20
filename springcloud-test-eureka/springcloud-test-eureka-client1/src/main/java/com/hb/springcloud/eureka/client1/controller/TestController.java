package com.hb.springcloud.eureka.client1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 测试
 *
 * @version v0.1, 2021/5/17 16:38, create by huangbiao.
 */
@RestController
@RequestMapping("/controller/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/method1")
    public Object method1() {
        return restTemplate.getForObject("http://localhost:8082/controller/test/method1", String.class);
    }

    @GetMapping("/method2")
    public Object method2() {
        return this.getClass().getName() + "#" + Thread.currentThread().getStackTrace()[1].getMethodName();
    }

}
