package com.cqupt.db;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.cqupt.mapper.RoleMapper;
import com.cqupt.mapper.NewRoleMapper;
import com.cqupt.pojo.Role;

public class DBAccess {
	public SqlSession getSqlSession(){
		SqlSession sqlSession=null;
		String resource="com/cqupt/config/Configuration.xml";
		try {
			InputStream inputStream=Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession=sqlSessionFactory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlSession;
	}
	
	public SqlSession getSqlSessionByCode(){
		SqlSession sqlSession = null;
		//���ݿ����ӳ���Ϣ
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mybatis?serverTimezone=UTC&charcaterEncoding=utf8&useUincode=true&useSSL=false");
		dataSource.setDefaultAutoCommit(false);
		//����Mybatis��JDBC����ʽ
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		//����configuration����
		Configuration configuration = new Configuration(environment);
		//ע��һ��MyBatis�������ı���
		configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
		//����һ��ӳ����
		configuration.addMapper(NewRoleMapper.class);//*****�˴�Ӧ�޸�ΪRole��ӳ��
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
	}

}
