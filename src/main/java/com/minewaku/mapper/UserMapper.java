package com.minewaku.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.minewaku.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel em = new UserModel();
		try {
			em.setUserId(resultSet.getLong("userId"));
			em.setRoleId(resultSet.getLong("roleId"));
			em.setUsername(resultSet.getString("username"));
			em.setPhone(resultSet.getString("phone"));
			em.setPassword(resultSet.getString("password"));
			em.setBirthday(resultSet.getDate("birthday"));
			em.setGender(resultSet.getString("gender"));
			em.setStatus(resultSet.getBoolean("status"));
			em.setCreatedDate(resultSet.getTimestamp("createdDate"));
			em.setModifiedDate(resultSet.getTimestamp("modifiedDate"));
			em.setCreatedBy(resultSet.getLong("createdBy"));
			em.setModifiedBy(resultSet.getLong("modifiedBy"));
			return em;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
