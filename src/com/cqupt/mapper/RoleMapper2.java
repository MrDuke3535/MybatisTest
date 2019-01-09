package com.cqupt.mapper;

import com.cqupt.pojo.Role2;

public interface RoleMapper2 {
	public Role2 getRole(long id);
	public Role2 findRoleByUserId(long userId);
}
