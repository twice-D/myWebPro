package com.gezhi.teamone.dao;

import java.util.List;

import com.gezhi.teamone.entity.Grade;

public interface GradeDao {

	/**
	 * 显示所有班级信息
	 * @return
	 */
	public List<Grade> findAllGrade();
	/**
	 * 实现班级添加，返回班级对象，为空，添加失败
	 * @return
	 */
	public Grade insertGrade();
	/**
	 * 修改班级信息，包括人数，带班老师等
	 */
	public void  updateGrade();
}
