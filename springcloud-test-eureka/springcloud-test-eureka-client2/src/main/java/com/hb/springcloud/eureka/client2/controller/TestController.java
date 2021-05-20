package com.hb.springcloud.eureka.client2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @version v0.1, 2021/5/17 16:35, create by huangbiao.
 */
@RestController
@RequestMapping("/controller/test")
public class TestController {

    @GetMapping("/method1")
    public Object method1() {
        return "My ClassName is: "+this.getClass().getName();
    }

    @GetMapping("/method2")
    public Object method2() {
        return this.getClass().getName() + "#" + Thread.currentThread().getStackTrace()[1].getMethodName();
    }

}
