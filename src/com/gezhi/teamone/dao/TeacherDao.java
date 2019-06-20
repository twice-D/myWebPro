package com.gezhi.teamone.dao;

import java.sql.SQLException;
import java.util.List;

import com.gezhi.teamone.entity.Grade;
import com.gezhi.teamone.entity.Teacher;

public interface TeacherDao {

	/**
	 * 查询显示所有老师
	 * @throws SQLException 
	 */
	public List<Teacher> findAllTeacher(int pageCurr) throws SQLException;
	/**
	 * 根据id删除，更新状态为0
	 * @throws SQLException 
	 */
	public void updateTeacherById(Integer teacherId) throws SQLException;
	/**
	 * 新增教师，新增后默认创建一个admin账号
	 * @return
	 * @throws SQLException 
	 */
	public Teacher insertTeacher(String tName, Integer tGender, String tTel, String address, Integer type,
			Integer adminId) throws SQLException;
	/**
	 * 点击老师显示详细信息以及其管理的班级
	 * @return
	 */
	public Teacher showMsgById(Integer teacherId)throws SQLException;
	/**
	 * 得到总页数
	 * @return
	 * @throws SQLException 
	 */
	public int getAllPageNums() throws SQLException; 
}
