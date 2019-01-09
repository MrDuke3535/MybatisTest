package com.cqupt.objectfactory;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

public class MyObjectFactory extends DefaultObjectFactory {
	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(MyObjectFactory.class);
	
	private Object temp = null;
	@Override
	public void setProperties(Properties properties){
		super.setProperties(properties);
		log.info("初始化参数：【"+properties.toString()+"】");
	}
	
	@Override
	public <T>T create(Class<T> type){
		T result = super.create(type);
		log.info("创建对象："+result.toString());
		log.info("是否和上次创建的是同一对象：【"+(temp==result)+"】");
		return result;
	}
	
	@Override
	public <T>T create(Class<T> type,List<Class<?>> constructorArgTypes,List<Object> constructorArgs){
		T result = super.create(type, constructorArgTypes, constructorArgs);
		log.info("创建对象："+result.toString());
		temp = result;
		return result;
	}
	
	@Override
	public <T> boolean isCollection(Class<T> type){
		return super.isCollection(type);
	}

}
