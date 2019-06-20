package com.gezhi.teamone.entity;

import java.io.Serializable;

public class Admin implements Serializable{

	private Integer adminId;
	private String adminName;
	private String adminPwd;
	private Teacher teacher;
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String adminName, String adminPwd) {
		super();
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}

	public Admin(Integer adminId, String adminName, String adminPwd, Teacher teacher) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.teacher = teacher;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPwd=" + adminPwd + ", teacher="
				+ teacher + "]";
	}
	
	
}
