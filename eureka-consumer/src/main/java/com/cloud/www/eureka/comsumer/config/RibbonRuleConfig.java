package com.cloud.www.eureka.comsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonRuleConfig {

    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
