package com.framework.serviceImpl;

import com.framework.dao.RegisterDao;
import com.framework.daoImpl.RegisterDaoImpl;
import com.framework.entity.User;
import com.framework.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

	RegisterDao addUser = new RegisterDaoImpl();
	@Override
	public boolean register(User user) {
		return addUser.register(user);
	}

}
