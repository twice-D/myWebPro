package com.gezhi.teamone.service;

import java.sql.SQLException;
import java.util.List;

import com.gezhi.teamone.entity.Teacher;

public interface TeacherService {
	/**
	 * 查询所有老师部分信息
	 * 
	 * @return
	 */
	public List<Teacher> findAllTeacher(int pageCurr);

	/**
	 * 根据id删除，更新状态为0
	 * 
	 */
	public void updateTeacherById(Integer teacherId);

	/**
	 * 新增教师，新增后默认创建一个admin账号
	 * 
	 * @return
	 */
	public Teacher insertTeacher(String tName, Integer tGender, String tTel, String address, Integer type,
			Integer adminId);

	/**
	 * 点击老师显示详细信息以及其管理的班级
	 * 
	 * @return
	 */
	public Teacher showMsgById(Integer teacherId);
	/**
	 * 得到总页数
	 * @return
	 */
	public int getAllPageNums();

}
