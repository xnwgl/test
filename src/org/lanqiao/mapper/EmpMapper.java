package org.lanqiao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.entity.Emp;
import org.lanqiao.entity.PageVo;

public interface EmpMapper {

	@Select(value={"select * from emp where empno=#{empno}"})
	public Emp GetEmpByEmpno(Integer empno);
	@Insert(value={"insert into emp values(#{empno},#{ename},#{job},#{mgr},#{hiredate},#{sal},#{comm},#{deptno})"})
	public void insertEmp(Emp emp);
	@Update(value={"update emp set ename=#{ename},job=#{job},mgr=#{mgr},hiredate=#{hiredate},sal=#{sal},comm=#{comm} where deptno=#{deptno}"})
	public void updateEmp(Emp emp);
	@Delete(value={"delete from emp where empno=#{empno}"})
	public void deleteEmp(Integer empno);
	
	//分页1
	public List<Emp> pagelist(PageVo pagevo);
	//分页2 pageHelper第三方插件
	public List<Emp> empList(int pagesize,int pageindex);
	
	
}
