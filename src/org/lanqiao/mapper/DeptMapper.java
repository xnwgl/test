package org.lanqiao.mapper;

import org.lanqiao.entity.Dept;

public interface DeptMapper {

	public Dept getDeptBydeptno(String deptno);
	public void insertDept(Dept dept);
	public void updateDept(Dept dept);
	public void deleteDept(String deptno);
}
