package com.gezhi.teamone.dao;

import java.util.List;

import com.gezhi.teamone.entity.StarStudent;
import com.gezhi.teamone.entity.Student;

public interface StarStudentDao {

	/**
	 * 显示所有明星学员
	 * @return
	 */
	public List<StarStudent> findAllStarStudent();
	/**
	 * 添加明星学院，（添加时工资必须大于七千）
	 * @return
	 */
	public StarStudent insertStarStudent(Student student,String company,Double salary);
	/**
	 * 修改明星学院信息，包括就业单位，工资信息，（修改时工资也必须大于七千）
	 */
	public void updaStarStudent(String stuName);
}
