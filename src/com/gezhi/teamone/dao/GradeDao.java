package com.gezhi.teamone.dao;

import java.util.List;

import com.gezhi.teamone.entity.Grade;
import com.gezhi.teamone.entity.Student;
import com.gezhi.teamone.entity.Teacher;

public interface GradeDao {
	/**
	 * 显示所有班级信息
	 * @return
	 */
	public List<Grade> findAllGrade(int pageNow)throws Exception;
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public int getPageCount() throws Exception;
	/**
	 * 
	 * 实现班级添加，返回班级对象，为空，添加失败
	 * @return
	 */
	public int insertGrade(String gradeName, String tName) throws Exception ;
	/**
	 * 查询名字是否存在
	 */
	public int  insertGrade1(String name) throws Exception;
	/**
	 * 修改班级信息，包括人数，带班老师等
	 */
	public int  updateGrade(String tName,String gName) throws Exception ;
	
	/**
	 * 查询老师
	 */
	List<Teacher> selectTeacher() throws Exception;
	
	/**
	 * 查询班级
	 */
	List<Grade> selectGrade() throws Exception;
	/**
	 * 模糊查询
	 * @return 
	 */
	List<Student> selectStudents(String sn) throws Exception;
}
