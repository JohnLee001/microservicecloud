package com.atguigu.springcloud.cotroller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

import java.util.List;

@RequestMapping("dept")
@RestController
public class DeptController {

  @Autowired
  private DeptService deptService;
  	@Autowired
	private DiscoveryClient client;
  
  @PostMapping
  public boolean addDept(Dept dept) {
    return deptService.addDept(dept);
  }

  //@HystrixCommand(fallbackMethod = "proccessHystrx_Get")
  @GetMapping("/{deptno}")
  public Dept findDept(@PathVariable String deptno) {
    Dept dept =  deptService.findDept(deptno);
    if (dept==null){
      throw new RuntimeException("不存在");
    }
    return dept;
  }
  
  @GetMapping("list")
  public List<Dept> deptList() {
    return deptService.deptList();
  }

  //	@Autowired
//	private DiscoveryClient client;访问路径：http://localhost:8001/dept/discovery
  @RequestMapping(value = "/discovery", method = RequestMethod.GET)
  public Object discovery()
  {
    List<String> list = client.getServices();
    System.out.println("**********" + list);

    List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
    for (ServiceInstance element : srvList) {
      System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
              + element.getUri());
    }
    return this.client;
  }

  public Dept proccessHystrx_Get(@PathVariable long deptno){
   Dept dept =  new Dept();
            dept.setDname("不存在");
            dept.setDeptno(deptno);
             return dept;
  }

}
