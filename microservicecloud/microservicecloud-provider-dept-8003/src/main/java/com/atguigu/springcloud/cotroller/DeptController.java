package com.atguigu.springcloud.cotroller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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
  
  @GetMapping("/{deptno}")
  public Dept findDept(@PathVariable String deptno) {
    return deptService.findDept(deptno);
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
}
