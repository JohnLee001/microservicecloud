package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

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
