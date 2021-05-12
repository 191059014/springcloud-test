package com.hb.springcloud.nacos.client1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * 测试
 *
 * @version v0.1, 2021/5/12 22:47, create by huangbiao.
 */
@RestController
public class TestController {

    @Autowired
    Environment env;

    @PostConstruct
    public void test() {
        System.out.println(env.getProperty("server.port"));
        System.out.println(env.getProperty("fullName"));
    }

}

    