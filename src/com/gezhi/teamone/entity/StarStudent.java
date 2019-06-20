package com.gezhi.teamone.entity;

import java.io.Serializable;

public class StarStudent implements Serializable{

	private Student student;
	private String company;
	private Double salary;
	public StarStudent(Student student, String company, Double salary) {
		super();
		this.student = student;
		this.company = company;
		this.salary = salary;
	}
	public StarStudent() {
		// TODO Auto-generated constructor stub
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "StarStudent [student=" + student + ", company=" + company + ", salary=" + salary + "]";
	}
	
}
