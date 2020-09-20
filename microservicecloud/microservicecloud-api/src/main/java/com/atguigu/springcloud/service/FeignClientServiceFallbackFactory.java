package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * 服务降级
 */
@Component
public class FeignClientServiceFallbackFactory implements FallbackFactory<FeinClientService> {
    @Override
    public FeinClientService create(Throwable throwable) {
        return new FeinClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept findDept(long deptno) {
                Dept dept =  new Dept();
                dept.setDname("不存在");
                dept.setDeptno(deptno);
                return dept;
            }

            @Override
            public List<Dept> deptList() {
                return null;
            }
        };
    }
}
