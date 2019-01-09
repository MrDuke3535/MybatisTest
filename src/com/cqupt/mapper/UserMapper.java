package com.cqupt.mapper;

import com.cqupt.pojo.User;

public interface UserMapper {
	public User getUser(Long id);
	public int countUserByFirstName(String firstName);
}
