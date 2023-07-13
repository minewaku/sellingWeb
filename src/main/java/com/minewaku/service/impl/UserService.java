package com.minewaku.service.impl;

import java.sql.Timestamp;
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
		model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		model.setCreatedBy(1);
		Long id = userDAO.save(model);
		return userDAO.findOne(id);
	}

	@Override
	public UserModel update(UserModel newModel) {
		UserModel oldModel = userDAO.findOne(newModel.getUserId());
		newModel.setCreatedDate(oldModel.getCreatedDate());
		newModel.setCreatedBy(oldModel.getCreatedBy());
		newModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setModifiedBy(1);
		userDAO.update(newModel);
		return userDAO.findOne(newModel.getUserId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			userDAO.delete(id);
		}
	}
	
}
