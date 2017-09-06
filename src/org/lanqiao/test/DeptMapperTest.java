package org.lanqiao.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Dept;
import org.lanqiao.mapper.DeptMapper;

public class DeptMapperTest {
	public static SqlSessionFactory factory;
	static{
		//加载配置文件
		String resource="mybatis-conf.xml";
		try {
			InputStream in=Resources.getResourceAsStream(resource);
			factory=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    @Test
	public void testgetDeptBydeptno(){
		SqlSession session=factory.openSession();
		DeptMapper mapper=session.getMapper(DeptMapper.class);
		Dept dept=mapper.getDeptBydeptno("10");
		session.close();
		System.out.println(dept);
	}
    @Test
	public void testinsertDept(){
		SqlSession session=factory.openSession();
		DeptMapper mapper=session.getMapper(DeptMapper.class);
		Dept dept=new Dept("12", "开心部", "泉州");
		mapper.insertDept(dept);
		session.commit();
		session.close();
		System.out.println(dept);
	}
    @Test
    public void testupdateDept(){
    	SqlSession session =factory.openSession();
    	DeptMapper mapper=session.getMapper(DeptMapper.class);
    	Dept dept=new Dept("12", "物料部", "杭州");
    	mapper.updateDept(dept);
    	session.commit();
    	session.close();
    	System.out.println(dept);
    }
    @Test
    public void testdeleteDept(){
    	SqlSession session =factory.openSession();
    	DeptMapper mapper=session.getMapper(DeptMapper.class);
    	mapper.deleteDept("12");
    	session.commit();
    	session.close();
    }
    
}
