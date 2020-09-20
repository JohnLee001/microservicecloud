package com.atguigu.springcloud;

import com.atguigu.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
//配置自定义的ribbon，配置之后再主启动类加载时会加载自定义的ribbon负载均衡策略，name表示使用该策略的微服务，configuration表示自定义策略的类
@RibbonClient(name = "microservicecloud-dept",configuration = MyselfRule.class)
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
