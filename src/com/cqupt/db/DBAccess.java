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
		//数据库连接池信息
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mybatis?serverTimezone=UTC&charcaterEncoding=utf8&useUincode=true&useSSL=false");
		dataSource.setDefaultAutoCommit(false);
		//采用Mybatis的JDBC事务方式
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		//创建configuration对象
		Configuration configuration = new Configuration(environment);
		//注册一个MyBatis的上下文别名
		configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
		//加入一个映射器
		configuration.addMapper(NewRoleMapper.class);//*****此处应修改为Role的映射
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
	}

}
