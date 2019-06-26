package com.gezhi.teamone.dao;

import java.sql.SQLException;
import java.util.List;

import com.gezhi.teamone.entity.StarStudent;
import com.gezhi.teamone.entity.Student;

public interface StarStudentDao {
     /**
      * 分页显示所有明星学员信息
      */
	public List<StarStudent> findAllStarStudent  (int pageNum) throws Exception;
	/**
	 * 
	 * 添加明星学员信息
	 */
	public void insertStarStudent(Student stu,String company,Double salary)throws Exception;
	/**
	 * 修改明星学院信息，包括就业单位，工资信息，（修改时工资也必须大于七千）
	 */
	public void updaStarStudent(String stuName,String company,Double salary)throws Exception;
	/**
	 * 明星学员分页
	 */
	public int getPageNum() throws Exception;
	/**
	 * 得到所有学员信息
	 */
	public List<StarStudent> findAllStudent  () throws Exception;
	/**
	 * 所有学员分页
	 */
	public int getPageNum1() throws Exception;
	 /**
     * 分页显示所有学员信息
     */
	public List<StarStudent> findAllStarStudent1 (int pageNum) throws Exception;
	
}
