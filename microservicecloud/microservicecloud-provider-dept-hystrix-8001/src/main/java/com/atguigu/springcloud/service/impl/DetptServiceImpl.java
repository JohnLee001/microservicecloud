package com.atguigu.springcloud.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

@Service
public class DetptServiceImpl implements DeptService{
  
  @Autowired
  private DeptDao deptDao;

  @Override
  public boolean addDept(Dept dept) {
    return deptDao.addDept(dept);
  }

  @Override
  public Dept findDept(String deptno) {
    return deptDao.findDept(deptno);
  }

  @Override
  public List<Dept> deptList() {
    return deptDao.deptList();
  }

}
