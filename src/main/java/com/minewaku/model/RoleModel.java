package com.minewaku.model;

import java.sql.Timestamp;

public class RoleModel extends AbstractModel{
	private long roleId;
	private String name;
	
	public RoleModel() {
		super();
	}
	
	public RoleModel(long roleId, String name, Timestamp createdDate, Timestamp modifiedDate, long createdBy, long modifiedBy) {
		super(createdDate, modifiedDate, createdBy, modifiedBy);
		this.roleId = roleId;
		this.name = name;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
