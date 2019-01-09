package com.cqupt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.cqupt.param.PageParams;
import com.cqupt.param.RoleParams;
import com.cqupt.pojo.PdCountRoleParams;
import com.cqupt.pojo.Role;

public interface RoleMapper {
	public Role getRole(Long id);
	public int deleteRole(Long id);
	public int updateRole(Role role);
	public List<Role> findRoles(String roleName);
	public int insertRole(Role role);
	public List<Role> findRolesByMap(Map<String,Object> map);
	public List<Role> findRolesByAnnotation(@Param("roleName") String roleName,@Param("note") String note);
	public List<Role> findRolesByBean(RoleParams roleParams);
	public List<Role> findRolesByMix(@Param("roleName") String roleName,@Param("note") String note,@Param("page") PageParams pageParams);
	public List<Role> findByRowBounds(@Param("roleName") String roleName,@Param("note") String note,RowBounds rowBounds);
	public void countRole(PdCountRoleParams pd);
}
