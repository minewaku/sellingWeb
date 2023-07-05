package com.minewaku.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.minewaku.dao.IUserDAO;
import com.minewaku.model.UserModel;
import com.minewaku.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;
	
	@Override
	public List<UserModel> findAll() {
		return userDAO.findAll();
	}
	
	@Override
	public List<UserModel> findByUserId(Long userId) {
		return userDAO.findByUserId(userId);
	}

	@Override
	public UserModel save(UserModel model) {
		Long id = userDAO.save(model);
		System.out.println(id);
		return null;
	}
	
}
