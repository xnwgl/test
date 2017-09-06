package org.lanqiao.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Dept;

public class DeptDaoImplTest {

	public static SqlSessionFactory factory;
	static{
		
		//1加载核心配置文件
		String resource="mybatis-conf.xml";
		
			InputStream in;
			try {
				in = Resources.getResourceAsStream(resource);
				factory=new SqlSessionFactoryBuilder().build(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}
	@Test
	public void testGetDeptBydeptno(){
		
		org.lanqiao.dao.DeptDao dao=new org.lanqiao.dao.DeptDao(factory);
		Dept dept=dao.getDeptByDeptno("10");
		System.out.println(dept);
	}
}
