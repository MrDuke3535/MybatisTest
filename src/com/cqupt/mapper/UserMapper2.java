package com.cqupt.mapper;

import com.cqupt.pojo.User2;

public interface UserMapper2 {
	public User2 getUser(long id);
	public User2 findUserByRoleId(long roleId);
}
