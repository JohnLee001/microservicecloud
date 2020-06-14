package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dept {

  /**
   * 部门编号
   */
  private long deptno;
  /**
   * 部门名称
   */
  private String dname;
  /**
       * 数据来源的数据库
   */
  private String db_source;
}
