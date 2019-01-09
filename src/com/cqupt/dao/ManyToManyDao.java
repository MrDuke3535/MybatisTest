package com.cqupt.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.cqupt.mapper.RoleMapper2;
import com.cqupt.mapper.UserMapper2;
import com.cqupt.pojo.Role;
import com.cqupt.pojo.Role2;
import com.cqupt.pojo.User2;
import com.cqupt.utils.SqlSessionFactoryUtils;

public class ManyToManyDao {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(ManyToManyDao.class);
		SqlSession sqlSession = null;
		try{
			sqlSession=SqlSessionFactoryUtils.openSqlSession();
			RoleMapper2 roleMapper=sqlSession.getMapper(RoleMapper2.class);
			Role2 role=roleMapper.getRole(1L);
			log.info(role.getUserList());
			UserMapper2 userMapper=sqlSession.getMapper(UserMapper2.class);
			User2 user=userMapper.getUser(1L);
			log.info(user.toString());
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
	}

}
