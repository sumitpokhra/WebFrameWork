package com.framework.dao;

import com.framework.entity.User;

public interface LoginDao {
	public boolean validateCredentials(User user);
}
