package com.gezhi.teamone.dao;

import java.util.List;

import com.gezhi.teamone.entity.Grade;
import com.gezhi.teamone.entity.Student;
import com.gezhi.teamone.entity.Teacher;

public interface StudentDao {

	/**
	 * 查询所有学生信息
	 * @return
	 */
	public List<Student> findAllStudent();
	/**
	 * 添加学生信息，返回学生对象，对象为空添加失败
	 * @return
	 */
	public Student insertStudent(String studentNum, String studentName, String studentIdcard,
			Integer studentGender, Integer studentAge, String studentectel, String studentTel, String studentWhere,
			Integer studentType, Grade grade, Teacher teacher);
	/**
	 * 修改学生信息修改的主要字段为（年龄  电话 班级 班主任）
	 */
	public void updateStudent(Integer studentId);
}
