package com.hb.springcloud.gateway.controller;

import com.google.gson.Gson;
import com.hb.springcloud.gateway.service.IDynamicRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路由的增删改查
 *
 * @version v0.1, 2021/5/17 16:38, create by huangbiao.
 */
@RestController
@RequestMapping("/controller/route")
public class RouteController {

    @Autowired
    private IDynamicRouteService iDynamicRouteService;

    /**
     * 获取所有路由信息
     *
     * @return 路由信息
     */
    @GetMapping("/getAll")
    public Object getAll() {
        return iDynamicRouteService.getAll();
    }

    /**
     * 添加路由
     *
     * @param routeJson 路由json串
     * @return 结果
     */
    @PostMapping("/add")
    public Object add(@RequestBody String routeJson) {
        Gson gson = new Gson();
        RouteDefinition routeDefinition = gson.fromJson(routeJson, RouteDefinition.class);
        return iDynamicRouteService.add(routeDefinition);
    }

    /**
     * 修改路由
     *
     * @param routeJson 路由json串
     * @return 结果
     */
    @PostMapping("/update")
    public Object update(@RequestBody String routeJson) {
        Gson gson = new Gson();
        RouteDefinition routeDefinition = gson.fromJson(routeJson, RouteDefinition.class);
        return iDynamicRouteService.update(routeDefinition);
    }

    /**
     * 删除路由
     *
     * @param routeId 路由id
     * @return 结果
     */
    @GetMapping("/delete")
    public Object delete(@RequestParam String routeId) {
        return iDynamicRouteService.delete(routeId);
    }

}
