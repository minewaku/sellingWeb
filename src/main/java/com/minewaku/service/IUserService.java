package com.minewaku.service;

import java.util.List;

import com.minewaku.model.UserModel;

public interface IUserService {
	List<UserModel> findAll();
	List<UserModel> findByUserId(Long userId);
	UserModel save(UserModel model);
	UserModel update(UserModel model);
	void delete(long[] ids);
}
