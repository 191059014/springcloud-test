package com.hb.springcloud.gateway.filter;

import com.hb.springcloud.gateway.common.FilterOrderEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义filter
 *
 * @version v0.1, 2021/5/20 11:46, create by huangbiao.
 */
@Component
@Slf4j
public class CustomerFilter3 implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("自定义filter={}，执行顺序={}", this.getClass().getName(), getOrder());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return FilterOrderEnum.getOrder(this.getClass().getName());
    }

}
