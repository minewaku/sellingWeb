package com.minewaku.dao.impl;

import java.util.List;

import com.minewaku.dao.IUserDAO;
import com.minewaku.mapper.UserMapper;
import com.minewaku.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM user";
		return query(sql, new UserMapper());
	}

	public List<UserModel> findByUserId(long userId) {
		String sql = "SELECT * FROM user where userId = ?";
		return query(sql, new UserMapper(), userId);
	}
	
	@Override
	public UserModel findOne(Long id) {
		String sql = "SELECT * FROM user WHERE userId = ?";
		List<UserModel> users = query(sql, new UserMapper(), id);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Long save(UserModel model) {
		String sql = "INSERT INTO user(roleId, username, phone, password, birthday, gender, status) VALUES(?, ?, ?, ?, ?, ?, ?)";
		return insert(sql, model.getRoleId(), model.getUsername(), model.getPhone(), model.getPassword(), model.getBirthday(), model.getGender(), model.isStatus(), model.getCreatedDate(), model.getCreatedBy());
	}
	
	@Override
	public void update(UserModel model) {
		String sql = "UPDATE user SET roleId = ?, username = ?, phone = ?, password = ?, birthday = ?, gender = ?, status = ? WHERE userId = ?";
		update(sql, model.getRoleId(), model.getUsername(), model.getPhone(), model.getPassword(), model.getBirthday(), model.getGender(), model.isStatus(), model.getUserId(), model.getCreatedDate(), model.getCreatedBy(), model.getModifiedDate(), model.getModifiedBy());
		
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM user WHERE userId = ?";
		update(sql, id);
	}
	
}
