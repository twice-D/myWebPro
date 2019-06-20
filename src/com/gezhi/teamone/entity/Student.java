package com.gezhi.teamone.entity;

import java.io.Serializable;

public class Student implements Serializable{

	private  Integer studentId;
	private String studentNum;
	private String studentName;
	private String studentIdcard;//身份证号
	private Integer studentGender;
	private Integer studentAge;
	private String studentectel;//紧急联系人
	private String studentTel;
	private String studentWhere;//学生来源
	private Integer studentType;
	private Grade grade;
	private Teacher teacher;

	
	public Student(Integer studentId, String studentNum, String studentName, String studentIdcard,
			Integer studentGender, Integer studentAge, String studentectel, String studentTel, String studentWhere,
			Integer studentType, Grade grade, Teacher teacher) {
		super();
		this.studentId = studentId;
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.studentIdcard = studentIdcard;
		this.studentGender = studentGender;
		this.studentAge = studentAge;
		this.studentectel = studentectel;
		this.studentTel = studentTel;
		this.studentWhere = studentWhere;
		this.studentType = studentType;
		this.grade = grade;
		this.teacher = teacher;
	}
	
	public Student(String studentNum, String studentName,  Integer studentGender, String studentTel, Grade grade, Teacher teacher) {
		super();
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.studentGender = studentGender;
		this.studentTel = studentTel;
		this.grade = grade;
		this.teacher = teacher;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(Integer studentGender) {
		this.studentGender = studentGender;
	}
	public Integer getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	public String getStudentTel() {
		return studentTel;
	}
	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}
	public String getStudentWhere() {
		return studentWhere;
	}
	public void setStudentWhere(String studentWhere) {
		this.studentWhere = studentWhere;
	}
	public Integer getStudentType() {
		return studentType;
	}
	public void setStudentType(Integer studentType) {
		this.studentType = studentType;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentNum=" + studentNum + ", studentName=" + studentName
				+ ", studentGender=" + studentGender + ", studentAge=" + studentAge + ", studentTel=" + studentTel
				+ ", studentWhere=" + studentWhere + ", studentType=" + studentType + ", grade=" + grade + ", teacher="
				+ teacher + "]";
	}
	
	
}
