package com.minewaku.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.minewaku.dao.IUserDAO;
import com.minewaku.mapper.UserMapper;
import com.minewaku.model.UserModel;

public class userDAO extends AbstractDAO<UserModel> implements IUserDAO {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sellingWeb";
			String user = "root";
			String password = "Mysqlmnwk11112003@@@";
			return DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM user";
		return query(sql, new UserMapper());
	}

	public List<UserModel> findByUserId(long userId) {
		String sql = "SELECT * FROM user where userId = ?";
		return query(sql, new UserMapper(), userId);
	}
}
