package com.framework.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.framework.dao.RegisterDao;
import com.framework.entity.User;
import com.framework.utils.DbConnection;

public class RegisterDaoImpl implements RegisterDao {
	Connection connection = null;

	@Override
	public boolean register(User user) {

		connection = DbConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into users (FirstName, MiddleName, LastName, UserName, Email, MobileNo, Address, Password) values(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getMiddleName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getUserName());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getMobileNo());
			preparedStatement.setString(7, user.getAddress());
			preparedStatement.setString(8, user.getPassword());
			preparedStatement.executeUpdate();
			if (preparedStatement.executeUpdate() >= 1) {
				System.out.println("executeUpdate: "+preparedStatement.executeUpdate());
			return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
