package com.minewaku.dao;

import java.util.List;

import com.minewaku.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findOne(Long id);
	List<UserModel> findAll();
	List<UserModel> findByUserId(long userId);
	Long save(UserModel model);
	void update(UserModel model);
}
