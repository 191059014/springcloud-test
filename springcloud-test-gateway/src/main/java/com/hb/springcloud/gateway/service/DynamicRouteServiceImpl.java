package com.hb.springcloud.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态路由服务
 *
 * @version v0.1, 2021/5/18 11:30, create by huangbiao.
 */
@Service
public class DynamicRouteServiceImpl implements IDynamicRouteService {

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private RouteDefinitionLocator routeDefinitionLocator;

    @Override
    public List<RouteDefinition> getAll() {
        Flux<RouteDefinition> routeFlux = routeDefinitionLocator.getRouteDefinitions();
        List<RouteDefinition> list = new ArrayList<>();
        routeFlux.subscribe(list::add);
        return list;
    }

    @Override
    public Object add(RouteDefinition definition) {
        routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        publisher.publishEvent(new RefreshRoutesEvent(this));
        return definition;
    }

    @Override
    public Object update(RouteDefinition definition) {
        delete(definition.getId());
        add(definition);
        return definition;
    }

    @Override
    public Object delete(String id) {
        routeDefinitionWriter.delete(Mono.just(id));
        return id;
    }

}
