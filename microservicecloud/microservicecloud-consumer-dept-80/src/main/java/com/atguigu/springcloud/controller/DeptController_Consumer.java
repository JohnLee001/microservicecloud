package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 访问的地址
     */
    private static final String REST_URL="http://localhost:8001/dept";

    @RequestMapping(value="/consumer/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL,dept,Boolean.class);
    }

    @RequestMapping(value="/consumer/dept/get/{deptno}")
    public Dept get(@PathVariable String deptno){
        return  restTemplate.getForObject(REST_URL+deptno,Dept.class);
    }

    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list(){
        return  restTemplate.getForObject(REST_URL+"/list",List.class);
    }
    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(REST_URL + "/dept/discovery", Object.class);
    }

}
