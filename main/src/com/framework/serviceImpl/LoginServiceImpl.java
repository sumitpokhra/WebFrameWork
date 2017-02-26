package com.framework.serviceImpl;

import com.framework.dao.LoginDao;
import com.framework.daoImpl.LoginDaoImpl;
import com.framework.entity.User;
import com.framework.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDao login = new LoginDaoImpl();

	@Override
	public boolean validateCredentials(User user) {

		return login.validateCredentials(user);
	}

}
