package com.minewaku.dao;

import java.util.List;

import com.minewaku.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	List<UserModel> findAll();
	List<UserModel> findByUserId(long userId);
}
