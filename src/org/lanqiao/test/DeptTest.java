package org.lanqiao.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Dept;

public class DeptTest {

	@Test
	public void testGetDeptBydeptno() throws IOException{
		
		//1加载mabatis核心配置文件
		String resource="mybatis-conf.xml";
        InputStream in=  Resources.getResourceAsStream(resource);
        //2根据核心配置文件创建一个工厂对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //3根据工厂对象创建session对象
       SqlSession session= factory.openSession();
        //4执行操作
       Dept dept= session.selectOne("ns.getDeptByDeptno", "10");
        //关闭操作
        session.close();
        System.out.println(dept);
        
	}
	@Test
	public void testgetDepts() throws IOException{

        //1加载mabatis核心配置文件
		String resource="mybatis-conf.xml";
        InputStream in=  Resources.getResourceAsStream(resource);
        //2根据核心配置文件创建一个工厂对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //3根据工厂对象创建session对象
       SqlSession session= factory.openSession();
        //4执行操作
       List<Dept> list=session.selectList("ns.getDepts");
       //关闭对象
       session.close();
       System.out.println(list);
	}
	@Test
	public void testgetDeptByDname() throws IOException{

        //1加载mabatis核心配置文件
		String resource="mybatis-conf.xml";
        InputStream in=  Resources.getResourceAsStream(resource);
        //2根据核心配置文件创建一个工厂对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //3根据工厂对象创建session对象
       SqlSession session= factory.openSession();
        //4执行操作
		List<Dept> list=session.selectList("ns.getDeptByDname","S");
		//5关闭连接
		session.close();
		System.out.println(list);

	}
	@Test
	public void testgetCount() throws IOException{
          //1加载mybatis核心配置文件
		String resource="mybatis-conf.xml";
		InputStream in=Resources.getResourceAsStream(resource);
         //2通过核心配置文件创建工厂对象
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//3通过工厂函数创建session对象
		SqlSession session=factory.openSession();
		//4执行操作
		int count=session.selectOne("ns.getCount");
		//5关闭连接
		session.close();
		System.out.println(count);

	}
	@Test
	public void testinsertDept() throws IOException{
		//1加载mybatis核心配置文件
		String resource="mybatis-conf.xml";
		InputStream in =Resources.getResourceAsStream(resource);
		//2通过配置文件创建工厂对象
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//3通过工厂对象创建session对象
		SqlSession session=factory.openSession();
		//4执行操作
		Dept dept=new Dept("12", "市场部","长春");
		session.insert("ns.insertDept", dept);
		session.commit();
        session.close();
	}
	@Test
	public void testupdateDept() throws IOException{
		//1加载mybatis核心配置文件
		String resource="mybatis-conf.xml";
		InputStream in =Resources.getResourceAsStream(resource);
		//2通过配置文件创建工厂对象
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//3通过工厂对象创建session对象
		SqlSession session=factory.openSession();
		//4执行操作
		Dept dept=new Dept("12", "dsf", "dsf");
		session.update("ns.updateDept", dept);
		
		session.commit();
        session.close();
	}
	@Test
	public void testdeleteDept() throws IOException{
		//1加载mybatis核心配置文件
		String resource="mybatis-conf.xml";
		InputStream in =Resources.getResourceAsStream(resource);
		//2通过配置文件创建工厂对象
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//3通过工厂对象创建session对象
		SqlSession session=factory.openSession();
	
		//4执行操作
				Dept dept=new Dept("12", "dsf", "dsf");
				session.delete("ns.deleteDept", dept);
	
		session.commit();
        session.close();
	}
}
