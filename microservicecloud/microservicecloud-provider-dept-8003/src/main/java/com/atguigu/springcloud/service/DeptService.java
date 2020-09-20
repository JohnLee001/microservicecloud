package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {

  /**
   * 新增部门
  * @param dept
  * @return
  */
 boolean addDept(Dept dept);
 /**
  * 根据主键查询部门信息
  * @param deptno
  * @return
  */
 Dept findDept(String deptno);
 /**
     * 查询所有部门信息 
  * @return
  */
 List<Dept> deptList();
}
