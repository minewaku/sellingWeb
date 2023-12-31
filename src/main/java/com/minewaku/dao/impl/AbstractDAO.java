package com.minewaku.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.minewaku.dao.GenericDAO;
import com.minewaku.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T>{
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sellingWeb";
			String user = "root";
			String password = "Mysqlmnwk11112003@@@";
			return DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			resultSet =  statement.executeQuery();
			while(resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			} 
			return results;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void setParameters(PreparedStatement statement, Object... parameters) {
		try {
			for(int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if(parameter instanceof Integer) {
					statement.setInt(index, (int) parameter);
				} else if(parameter instanceof Long) {
					statement.setLong(index, (long) parameter);
				} else if(parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if(parameter instanceof Float) {
					statement.setFloat(index, (Float) parameter);
				} else if(parameter instanceof Double) {
					statement.setDouble(index, (Double) parameter);
				} else if(parameter instanceof Boolean) {
					statement.setBoolean(index, (Boolean) parameter);
				} else if(parameter instanceof Date) {
					statement.setDate(index, (Date) parameter);
				} else if(parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				} else if(parameter == null) {
					statement.setNull(index, Types.NULL);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 	insert and update are not the same with save, update and delete functions from DAO. The insert is used for save will return id 
	 while update do not return anything
	 */
	
	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long id = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			setParameters(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch(SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				} 
				if(resultSet != null) {
					resultSet.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch(SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
