package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient //注册中心
@EnableDiscoveryClient //发现服务
@EnableCircuitBreaker
public class DeptProvider8001Hystrix_App {

  public static void main(String[] args) {
   SpringApplication.run(DeptProvider8001Hystrix_App.class, args);
  }

}
