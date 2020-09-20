package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

/**
 * fallbackFactory = FeignClientServiceFallbackFactory.class 配置服务降级
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = FeignClientServiceFallbackFactory.class)
public interface FeinClientService {

    @PostMapping
    boolean addDept(Dept dept);

    @GetMapping("dept/{deptno}")
    Dept findDept(@PathVariable long deptno);

    @GetMapping("dept/list")
    List<Dept> deptList();
}
