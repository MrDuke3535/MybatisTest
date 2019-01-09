package com.cqupt.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.cqupt.db.DBAccess;
import com.cqupt.mapper.RoleMapper;
import com.cqupt.mapper.NewRoleMapper;
import com.cqupt.param.PageParams;
import com.cqupt.param.RoleParams;
import com.cqupt.pojo.PdCountRoleParams;
import com.cqupt.pojo.Role;
import com.cqupt.utils.SqlSessionFactoryUtils;

public class RoleDao {

//	public static void main(String[] args) {
//		DBAccess dbAccess = new DBAccess();
//		//SqlSession sqlSession = dbAccess.getSqlSessionByCode();
//		SqlSession sqlSession = dbAccess.getSqlSession();
//		//Role role = sqlSession.selectOne("getRole", 2L);
//		//System.out.println(role.toString());
//		RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
//		Role role=roleMapper.getRole(1L);
//		System.out.println(role);
//	}
	
	
//	public static void main(String[] args) {
//		DBAccess dbAccess = new DBAccess();
//		SqlSession sqlSession = null;
//		try{
//			sqlSession=dbAccess.getSqlSession();
//			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
//			Role role = roleMapper.getRole(1L);
//			System.out.println(role);
//		}catch(Exception ex){
//			sqlSession.rollback();
//		}finally{
//			if(sqlSession!=null){
//				sqlSession.close();
//			}
//		}
//	}

	public static void main(String[] args) {
		Logger log = Logger.getLogger(RoleDao.class);
		SqlSession sqlSession = null;
//		SqlSession sqlSession2 = null;
		try{
			sqlSession=SqlSessionFactoryUtils.openSqlSession();
			RoleMapper mapper=sqlSession.getMapper(RoleMapper.class);
			PdCountRoleParams params = new PdCountRoleParams();
		    params.setRoleName("’≈");
			mapper.countRole(params);
			log.info(params.getTotal());
			log.info(params.getExecDate());
//			Role role = mapper.getRole(1L);
//			log.info(role.toString());
//			sqlSession.commit();
//			sqlSession2 = SqlSessionFactoryUtils.openSqlSession();
//			RoleMapper roleMapper2=sqlSession2.getMapper(RoleMapper.class);
//			Role role2 = roleMapper2.getRole(1L);
//			log.info(role2);
//			sqlSession2.commit();
			//Map<String,Object> map = new HashMap<String, Object>();
			//map.put("roleName", "’≈");
			//map.put("note", "¿≤");
			//List<Role> roles=mapper.findRolesByMap(map);
			//List<Role> roles = mapper.findRolesByAnnotation("’≈", "¿≤");
//			RoleParams roleParams = new RoleParams();
//			roleParams.setRoleName("’≈");
//			roleParams.setNote("¿≤");
//			List<Role> roles = mapper.findRolesByBean(roleParams);
			//PageParams pageParams = new PageParams();
			//pageParams.setStart(0);
			//pageParams.setLim(3);
			//List<Role> roles = mapper.findRolesByMix("’≈", "¿≤", pageParams);
//			RowBounds rowBounds = new RowBounds(0,2);
//			List<Role> roles = mapper.findByRowBounds("’≈", "¿≤", rowBounds);
//			log.info(roles.toString());
			//Role role = new Role();
			//role.setRoleName("’≈∆‰");
			//role.setNote("¿≤¿≤¿≤¿≤¿≤¿≤¬Ã¬Ã¬Ã¬Ã");
			//mapper.insertRole(role);
			//sqlSession.commit();
			//log.info(role.getId());
			//Role role=mapper.getRole(1L);
			//Role role = new Role();
			//role.setRoleName("¡ı¡˘");
			//role.setNote("π˛π˛");
			//role.setId(5L);
			//mapper.updateRole(role);
			//mapper.insertRole(role);
			//sqlSession.commit();
			//log.info(role.getRoleName());
			//System.out.println(role.getId());
			//System.out.println(role.getNote());
			//System.out.println(role.getRoleName());
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
