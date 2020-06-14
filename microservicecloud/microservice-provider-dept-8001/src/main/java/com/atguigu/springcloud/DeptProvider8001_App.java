package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient //注册中心
//@EnableDiscoveryClient //发现服务
public class DeptProvider8001_App {

  public static void main(String[] args) {
   SpringApplication.run(DeptProvider8001_App.class, args);
  }

}
