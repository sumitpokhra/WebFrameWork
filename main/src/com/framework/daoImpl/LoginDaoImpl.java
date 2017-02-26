package com.framework.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.framework.dao.LoginDao;
import com.framework.entity.User;
import com.framework.utils.DbConnection;

public class LoginDaoImpl implements LoginDao {

	Connection connection = null;

	@Override
	public boolean validateCredentials(User user) {

		connection = DbConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("select username,password from users where username=? and password=?");
				preparedStatement.setString(1, user.getUserName());
				preparedStatement.setString(2, user.getPassword());
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					return true;
				} else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			return false;
		}
		return connection != null;

	}

}
