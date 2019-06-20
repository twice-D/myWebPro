package com.gezhi.teamone.entity;

import java.io.Serializable;
import java.util.List;

public class Teacher implements Serializable{

	private Integer teacherId;
	private String tName;
	private Integer tGender;
    private String tTel;
	private String address;
	private Integer type;
	private Integer adminId;
	private StringBuffer image;
	private List<Grade> grades;



	public Teacher(Integer teacherId, String tName, Integer tGender, String tTel, String address, Integer type,
			Integer adminId, StringBuffer image, List<Grade> grades) {
		super();
		this.teacherId = teacherId;
		this.tName = tName;
		this.tGender = tGender;
		this.tTel = tTel;
		this.address = address;
		this.type = type;
		this.adminId = adminId;
		this.image = image;
		this.grades = grades;
	}

	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	
	public Teacher(String tTel, String address, List<Grade> grades) {
		super();
		this.tTel = tTel;
		this.address = address;
		this.grades = grades;
	}

	public Teacher(Integer teacherId, String tName, Integer tGender, Integer type, Integer adminId) {
		super();
		this.teacherId = teacherId;
		this.tName = tName;
		this.tGender = tGender;
		this.type = type;
		this.adminId = adminId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public Integer gettGender() {
		return tGender;
	}
	public void settGender(Integer tGender) {
		this.tGender = tGender;
	}
	public String gettTel() {
		return tTel;
	}
	public void settTel(String tTel) {
		this.tTel = tTel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", tName=" + tName + ", tGender=" + tGender + ", tTel=" + tTel
				+ ", address=" + address + ", type=" + type + ", adminId=" + adminId + ", grades=" + grades + "]";
	}
	

	
	
}
