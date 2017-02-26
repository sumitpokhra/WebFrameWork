package com.framework.service;

import com.framework.entity.User;

public interface LoginService {

	public boolean validateCredentials(User user);
}
