package com.hb.springcloud.gateway.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hb.springcloud.gateway.service.IDynamicRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 动态路由配置
 *
 * @version v0.1, 2021/5/18 11:49, create by huangbiao.
 */
@Configuration
@Slf4j
public class DynamicRouteConfig {

    // 路由json串，可从配置文件里面读取，此处写死，具体可参考classpath下route.json文件
    private String routeJson = "[{\"id\": \"route_client2_use_url_id\", \"order\": 1, \"predicates\": [{\"args\": {\"pattern\": \"/client2Url/**\"}, \"name\": \"Path\"} ], \"filters\": [{\"args\": {\"parts\": \"1\"}, \"name\": \"StripPrefix\"} ], \"uri\": \"http://localhost:8082\"} ]";

    @Autowired
    private IDynamicRouteService iDynamicRouteService;

    @PostConstruct
    public void init() {
        Gson gson = new Gson();
        List<RouteDefinition> routeDefinitionList = gson.fromJson(routeJson, new TypeToken<List<RouteDefinition>>() {
        }.getType());
        for (RouteDefinition definition : routeDefinitionList) {
            iDynamicRouteService.add(definition);
        }
        log.info("读取json文件，然后添加路由：{}", routeDefinitionList);
    }

}
