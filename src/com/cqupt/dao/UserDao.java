package com.cqupt.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.cqupt.mapper.UserMapper;
import com.cqupt.pojo.User;
import com.cqupt.utils.SqlSessionFactoryUtils;

public class UserDao {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(UserDao.class);
		SqlSession sqlSession = null;
		try{
			sqlSession=SqlSessionFactoryUtils.openSqlSession();
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			int num=userMapper.countUserByFirstName("��");
			log.info("��"+num+"���û�����");
//			User user=userMapper.getUser(1L);
//			log.info(user.getSex());
//			log.info(user.getSex().getName());
		}catch(Exception ex){
			ex.printStackTrace();
			sqlSession.rollback();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}

}
