package com.gezhi.teamone.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.gezhi.teamone.dao.TeacherDao;
import com.gezhi.teamone.dao.impl.TeacherDaoImpl;
import com.gezhi.teamone.entity.Teacher;
import com.gezhi.teamone.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	TeacherDao tdao = null;

	public TeacherServiceImpl() {
		tdao = new TeacherDaoImpl();
	}

	@Override
	public List<Teacher> findAllTeacher(int pageCurr) {
		try {
			List<Teacher> list = tdao.findAllTeacher(pageCurr);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void updateTeacherById(Integer teacherId) {
		// TODO Auto-generated method stub
		try {
			tdao.updateTeacherById(teacherId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Teacher insertTeacher(String tName, Integer tGender, String tTel, String address, Integer type,
			Integer adminId) {
		// TODO Auto-generated method stub
		try {
			Teacher teacher = tdao.insertTeacher(tName, tGender, tTel, address, type, adminId);
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Teacher showMsgById(Integer teacherId) {
		// TODO Auto-generated method stub
		try {
			Teacher teacherInfo = tdao.showMsgById(teacherId);
			return teacherInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getAllPageNums() {
		// TODO Auto-generated method stub
		try {
			int pageNum = tdao.getAllPageNums();
			return pageNum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void changeImagByName(String url, String name) {
		// TODO Auto-generated method stub
		try {
			tdao.changeImagByName(url, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getUrlByName(String name) {
		// TODO Auto-generated method stub
		try {
			String url = tdao.getUrlByName(name);
			return url;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void changUserInfoByName(String newName, String newTel, String newAddress, String nowname) {
		// TODO Auto-generated method stub
		try {
			tdao.changUserInfoByName(newName, newTel, newAddress, nowname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Teacher> findAllTeacherByInput(String str) {
		// TODO Auto-generated method stub
		try {
			List<Teacher> list = tdao.findAllTeacherByInput(str);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
