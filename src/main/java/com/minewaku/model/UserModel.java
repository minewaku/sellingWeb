package com.minewaku.model;

import java.sql.Date;

public class UserModel extends AbstractModel<UserModel> {
	
//	missing imageurl for test
	private long userId;
	private long roleId;
	private String username;
	private String phone;
	private String password;
	private Date birthday;
	private String gender;
	private boolean status;
	
	public UserModel() {
		
	}

	public UserModel(long userId, long roleId, String username, String phone, String password, Date birthday, String gender,
			boolean status) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.username = username;
		this.phone = phone;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
		this.status = status;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
