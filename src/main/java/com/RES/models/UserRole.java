package com.RES.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="User_role")

public class UserRole {
	@Id
	@Column(name = "reim_role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int RoleId;
	
	@Column(name = "reimb_role")
	private String reRole;
	@OneToMany(mappedBy="RembRole",fetch=FetchType.LAZY)
	private List<Users> userList=new ArrayList<Users>();
	
	public UserRole() {
		super();
	}
	
	public UserRole(String reRole) {
		super();
		this.reRole = reRole;
	}

	public UserRole(int roleId, String reRole, List<Users> userList) {
		super();
		RoleId = roleId;
		this.reRole = reRole;
		this.userList = userList;
	}

	public UserRole(int roleId, String reRole) {
		super();
		RoleId = roleId;
		this.reRole = reRole;
	}

	public UserRole(String reRole, List<Users> userList) {
		super();
		this.reRole = reRole;
		this.userList = userList;
	}

	public int getRoleId() {
		return RoleId;
	}

	public void setRoleId(int roleId) {
		RoleId = roleId;
	}

	public String getReRole() {
		return reRole;
	}

	public void setReRole(String reRole) {
		this.reRole = reRole;
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "UserRole [RoleId=" + RoleId + ", reRole=" + reRole + ", userList=" + userList + "]";
	}
	
	
}
