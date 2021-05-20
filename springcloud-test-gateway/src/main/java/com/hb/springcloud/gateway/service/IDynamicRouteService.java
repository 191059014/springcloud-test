package com.hb.springcloud.gateway.service;

import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.List;

/**
 * 动态路由服务接口
 *
 * @version v0.1, 2021/5/18 11:38, create by huangbiao.
 */
public interface IDynamicRouteService {

    /**
     * 获取所有路由信息
     *
     * @return 路由信息列表
     */
    List<RouteDefinition> getAll();

    /**
     * 增加路由
     *
     * @param definition 路由定义信息
     * @return 结果
     */
    public Object add(RouteDefinition definition);

    /**
     * 更新路由
     *
     * @param definition 路由定义信息
     * @return 结果
     */
    public Object update(RouteDefinition definition);

    /**
     * 删除路由
     *
     * @param id 路由id
     * @return 结果
     */
    public Object delete(String id);

}
