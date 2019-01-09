package com.cqupt.mapper;

import org.apache.ibatis.annotations.Select;

import com.cqupt.pojo.Role;

public interface NewRoleMapper {
	@Select("select id ,role_name as roleName,note from t_role where id=#{id}")
	public Role getRole(Long id);
}
