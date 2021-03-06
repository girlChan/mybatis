package cn.liuchan.Dao;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.liuchan.Do.Student;

public class IStudentDaoImpl implements IStudentDao{

	private SqlSession sqlSession;

	@Override
	public void insertStudent(Student student) {
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sessionFactory.openSession();
			sqlSession.insert("insertStudent", student);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
	}

}
