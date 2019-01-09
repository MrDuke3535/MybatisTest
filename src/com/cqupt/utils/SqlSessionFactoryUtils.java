package com.cqupt.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

	private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
	private static SqlSessionFactory sqlSessionFactory= null;
	private  SqlSessionFactoryUtils(){}
	public static SqlSessionFactory getSqlSessionFactory(){
		synchronized(LOCK){
			if(sqlSessionFactory!=null){
				return sqlSessionFactory;
			}
			String resource = "com/cqupt/config/Configuration.xml";
			InputStream inputStream;
			InputStream in ;
			try {
				in = Resources.getResourceAsStream("jdbc.properties");
				Properties props = new Properties();
				props.load(in);
				String username=props.getProperty("database.username");
				String password=props.getProperty("database.password");
				props.put("database.username", CodeUtils.decode(username));
				props.put("database.password", CodeUtils.decode(password));
				inputStream=Resources.getResourceAsStream(resource);
				sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream,props);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			return sqlSessionFactory;
		}
	}
	
	public static SqlSession openSqlSession(){
		if(sqlSessionFactory==null){
			getSqlSessionFactory();
		}
		return sqlSessionFactory.openSession();
	}

}
