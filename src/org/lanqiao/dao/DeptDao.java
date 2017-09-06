package org.lanqiao.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.lanqiao.entity.Dept;

public class DeptDao {

	private SqlSessionFactory factory=null;
	
	public DeptDao(SqlSessionFactory factory) {
          this.factory=factory;//通过构造方法注入factory对象
	}
	public Dept getDeptByDeptno(String deptno){
		
		SqlSession session=factory.openSession();
		Dept dept=session.selectOne("ns.getDeptByDeptno", deptno);
		session.close();
		return dept;
		
	}
	public void insertDept(Dept dept){
		SqlSession session=factory.openSession();
		
		session.insert("insertDept", dept);
		session.commit();
		session.close();
	}
}
