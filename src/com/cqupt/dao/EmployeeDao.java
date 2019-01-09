package com.cqupt.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import com.cqupt.mapper.EmployeeMapper;
import com.cqupt.pojo.Employee;
import com.cqupt.utils.SqlSessionFactoryUtils;

public class EmployeeDao {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(EmployeeDao.class);
		SqlSession sqlSession = null;
		try{
			sqlSession=SqlSessionFactoryUtils.openSqlSession();
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee employee=employeeMapper.getEmployee(1L);
			log.info(employee.getBirthday());
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
