package org.lanqiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Emp;
import org.lanqiao.entity.PageVo;
import org.lanqiao.mapper.EmpMapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class EmpMapperTest {
	private static SqlSessionFactory factory;
	static{
		//加载核心配置文件
		String resource="mybatis-conf.xml";
		try {
			InputStream in=Resources.getResourceAsStream(resource);
			factory=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    @Test
	public void testGetEmpByEmpno(){
		SqlSession session=factory.openSession();
		EmpMapper empmapper=session.getMapper(EmpMapper.class);
		Emp emp=empmapper.GetEmpByEmpno(7369);
		System.out.println(emp);
	}
    @Test
    public void testinsert(){
    	SqlSession session=factory.openSession();
    	EmpMapper empmapper=session.getMapper(EmpMapper.class);
         Emp emp=new Emp(new Integer(1212), "哈哈", "哈哈", new Integer(7369), new Date(), new Double(6000), new Double(600), new Integer(10));
    	empmapper.insertEmp(emp);
      session.commit();
      session.close();
    }
    @Test
    public void testupdateEmp(){
    	SqlSession session=factory.openSession();
    	EmpMapper empmapper=session.getMapper(EmpMapper.class);
    	Emp emp=new Emp(1212, "哈喽", "哈喽",new Integer(7902),new Date(),  new Double(7000), new Double(600), new Integer(20));
    	empmapper.updateEmp(emp);
    	 session.commit();
         session.close();
    }
    @Test
    public void testdeleteEmp(){
    	SqlSession session=factory.openSession();
    	EmpMapper empmapper=session.getMapper(EmpMapper.class);
    	empmapper.deleteEmp(1111); 
    	session.commit();
        session.close();
    	
    }
    
    //分页1
    @Test
    public void pagelist(){
    	SqlSession session=factory.openSession();
    	EmpMapper empmapper=session.getMapper(EmpMapper.class);
  
    	PageVo pagevo=new PageVo();
    	pagevo.setPageindex(1);
    	pagevo.setPagesize(2);
    	List<Emp> list=empmapper.pagelist(pagevo);
    	System.out.println(list);
    	
    }
  //分页2
    @Test
    public void testpageList(){
    	SqlSession session=factory.openSession();
    	EmpMapper empmapper=session.getMapper(EmpMapper.class);
         //分页插件中写的分页类 可以通过pageinfoq取总数量等数据
//    	PageInfo<Emp> pageinfo=new PageInfo<Emp>();
//    	pageinfo.setSize(2);
    	int pagesize=2;
    	int pageindex=1;
    	
    	Page<Emp> pager=PageHelper.startPage(pageindex,pagesize);
    	List<Emp> list=empmapper.empList(pagesize,pageindex);
    	//System.out.println(list);
    	
    	//取数据
    	PageInfo<Emp> pageinfo=new PageInfo<Emp>(list);
	//打印出数据库中的第一条数据
    	//System.out.println(pageinfo.getList().get(0));
   //取出每页数据1
//    	for(Emp e:pageinfo.getList()){
//    		System.out.println(e);
//    	}
    	//System.out.println(pageinfo);
    	//取出每页数据2
    	for(Emp e:list){
    		System.out.println(e);
    	}
    	
    }
}
