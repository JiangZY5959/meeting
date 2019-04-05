package com.caztc.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ����������
 * 
 * @author Administrator
 * 
 */
public class DBFactoryUtils {

	private static SqlSessionFactory sqlSessionFactory = null;

	private static SqlSession sqlSession = null;

	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(
					inputStream, "mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡSqlSession
	 * 
	 * @return
	 */
	public static SqlSession getSqlSession() {

		if (sqlSession == null) {
			sqlSession = sqlSessionFactory.openSession();
		}

		return sqlSession;

	}

	/**
	 * ��ȡgetMapper
	 * 
	 * @param mapper
	 * @return
	 */
	public static <T> T getMapper(Class<T> mapper) {
		SqlSession session = getSqlSession();

		return (T) session.getMapper(mapper);
	}

	/**
	 * �ύ����
	 */
	public static void commit() {
		sqlSession.commit();
	}

	/**
	 * �ع�
	 */
	public static void rollback() {
		sqlSession.rollback();
	}

	/**
	 * �ر�session
	 */
	public static void close() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}



}
