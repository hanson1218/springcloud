package com.cloud.www.geteway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class CustomGatewayFilterFactory extends AbstractGatewayFilterFactory<CustomGatewayFilterFactory.Config> {

    public CustomGatewayFilterFactory() {
        super(Config.class);
        log.info("加载 自定义拦截器 [Custom]...");
    }

    @Override
    public Config newConfig() {
        return new Config();
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("enabled");
    }

    /**
     * @param config
     * @return
     */
    @Override
    public GatewayFilter apply(CustomGatewayFilterFactory.Config config) {
        return (exchange, chain) -> {

            //Custom=false 跳过验证
            if (!config.isEnabled()) {
                return chain.filter(exchange);
            }

            //获取请求信息
            ServerHttpRequest request = exchange.getRequest();
            HttpHeaders headers = request.getHeaders();

            //获取请求参数
            //具体业务略....
            String token = headers.getFirst("token");
            System.out.println("====token===="+token);
            return chain.filter(exchange);
        };
    }


    public static class Config {
        /**
         * 控制是否开启拦截器
         */
        private boolean enabled;

        public Config() {}

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
