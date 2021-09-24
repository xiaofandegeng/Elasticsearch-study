package cn.itcast.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

/**
 * @Description 登录权限网关
 * @Author lhw
 * @Date 2021/9/24 21:53
 * @Version 1.0
 **/
@Component
public class AuthorizeFilter implements GlobalFilter, Order {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1.获取请求参数
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        // 2.获取authorization参数
        String auth = queryParams.getFirst("authorization");
        // 3.校验
        if ("admin".equals(auth)) {
            return chain.filter(exchange);
        }
        // 4.拦截
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    @Override
    public int value() {
        return 0;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
