package com.gezhi.teamone.entity;

import java.io.Serializable;

public class Grade implements Serializable{

	private String gradeName;
	private Integer nowStudent;
	private Integer teacherId;
	private Teacher teacher;
	public Grade(String gradeName, Integer nowStudent, Integer teacherId) {
		super();
		this.gradeName = gradeName;
		this.nowStudent = nowStudent;
		this.teacherId = teacherId;
	}
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public Integer getNowStudent() {
		return nowStudent;
	}
	public void setNowStudent(Integer nowStudent) {
		this.nowStudent = nowStudent;
	}

	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Grade [gradeName=" + gradeName + ", nowStudent=" + nowStudent + ", teacherId=" + teacherId
				+ ", teacher=" + teacher + "]";
	}
	
	
	
}
