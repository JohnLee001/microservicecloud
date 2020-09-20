package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * ribbon的IRule组件,用于根据特定算法中从服务列表中选取一个需要访问的服务
     */
    @Bean
    public IRule myRule(){
       // return new RoundRobinRule(); //轮询
        //return new RandomRule(); //随机
        return new RetryRule(); //重试，如果都可用则默认轮询
    }
}
