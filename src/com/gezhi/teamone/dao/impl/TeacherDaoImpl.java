package com.gezhi.teamone.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gezhi.teamone.dao.TeacherDao;
import com.gezhi.teamone.entity.Grade;
import com.gezhi.teamone.entity.Teacher;
import com.gezhi.teamone.utils.C3P0Utils;

public class TeacherDaoImpl implements TeacherDao {

	static final int PAGE_SIZE = 5;
	static final int DEFALUT_TYPE=1;
	@Override
	public List<Teacher> findAllTeacher(int pageCurr) throws SQLException {
		// TODO Auto-generated method stub
		List<Teacher> list = new ArrayList<Teacher>();
		Connection con = C3P0Utils.getCon();
		PreparedStatement prep = con.prepareStatement("SELECT t.teacher_id,  t.teacher_name ,t.teacher_gender, t.teacher_tel , t.teacher_address , t.teacher_type, t.admin_id  FROM tb_teacher t where teacher_type=1 limit ?,?");
        prep.setInt(1, (pageCurr-1)*PAGE_SIZE);
        prep.setInt(2, PAGE_SIZE);
        ResultSet res = prep.executeQuery();
		while (res.next()) {
			Teacher teacher = new Teacher();
			teacher.setTeacherId(res.getInt("teacher_id"));
			teacher.settName(res.getString("teacher_name"));
			teacher.settGender(res.getInt("teacher_gender"));
			teacher.settTel(res.getString("teacher_tel"));
			teacher.setAddress(res.getString("teacher_address"));
			teacher.setType(res.getInt("teacher_type"));
			teacher.setAdminId(res.getInt("admin_id"));
			list.add(teacher);
		}
		C3P0Utils.closeAll(res, null, con);
		return list;
	}

	@Override
	public void updateTeacherById(Integer teacherId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = C3P0Utils.getCon();
		PreparedStatement prep = con
				.prepareStatement("update tb_teacher  t set  t.teacher_type=0 where t.teacher_id=?");
		prep.setInt(1, teacherId);
		prep.executeUpdate();
		C3P0Utils.closeAll(null, prep, con);

	}

	@Override
	public Teacher insertTeacher(String tName, Integer tGender, String tTel, String address, Integer type,
			Integer adminId) throws SQLException {
		// TODO Auto-generated method stub
		type = 1;
		Connection con = C3P0Utils.getCon();
		PreparedStatement prep = con.prepareStatement(
				"insert into tb_teacher (teacher_name,teacher_gender,teacher_tel,teacher_address,teacher_type) values(?,?,?,?,?)");
		prep.setString(1, tName);
		prep.setInt(2, tGender);
		prep.setString(3, tTel);
		prep.setString(4, address);
		prep.setInt(5, type);
		prep.executeUpdate();
		PreparedStatement prepareStatement = con.prepareStatement("select teacher_id from tb_teacher where teacher_name=?");
		prepareStatement.setString(1, tName);
		ResultSet res = prepareStatement.executeQuery();
		int teacherId = 0;
		if(res.next()) {
			teacherId = res.getInt("teacher_id");
		}
		Teacher teacher = new Teacher(teacherId, tName, tGender, type, adminId);
		C3P0Utils.closeAll(res, prepareStatement, con);
		return teacher;
	}

	@Override
	public Teacher showMsgById(Integer teacherId) throws SQLException {
		// TODO Auto-generated method stub
		List<Grade> grades = new ArrayList<Grade>();
		Connection con = C3P0Utils.getCon();
		PreparedStatement prep = con.prepareStatement("select g.grade_name,g.nowstudent,teacher_id from tb_grade g where teacher_id=?");
		prep.setInt(1, teacherId);
		ResultSet res = prep.executeQuery();
		Grade grade = null;
		while(res.next()) {
			String gradeName = res.getString("grade_name");
			Integer nowStudent = res.getInt("nowstudent");
			Integer id = res.getInt("teacher_id");
			grade = new Grade(gradeName, nowStudent, id);
			grades.add(grade);
		}
		PreparedStatement prep1 = con.prepareStatement("select t.teacher_tel,t.teacher_address from tb_teacher t where teacher_id=?");
		prep1.setInt(1, teacherId);
		ResultSet query = prep1.executeQuery();
		Teacher teacher = null;
		if(query.next()) {
			String tTel = query.getString("teacher_tel");
			String address = query.getString("teacher_address");
			teacher = new Teacher(tTel, address, grades);
		}
		return teacher;
	}

	@Override
	public int getAllPageNums() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(teacher_id) count from tb_teacher where teacher_type=?";
		int pageNum = 0;
		int allTotal = 0;
		Connection con = C3P0Utils.getCon();
		PreparedStatement prep = con.prepareStatement(sql);
		prep.setInt(1, DEFALUT_TYPE);
		ResultSet res = prep.executeQuery();
		if(res.next()) {
			allTotal = res.getInt("count");
		}
		pageNum = allTotal%PAGE_SIZE == 0 ? allTotal/PAGE_SIZE : allTotal/PAGE_SIZE + 1;//判断总页数
		return pageNum;
	}

}
