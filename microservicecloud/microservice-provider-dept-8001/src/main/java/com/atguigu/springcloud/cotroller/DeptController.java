package com.atguigu.springcloud.cotroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

@RequestMapping("/dept")
@RestController
public class DeptController {

  @Autowired
  private DeptService deptService;
  
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
}
