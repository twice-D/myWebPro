package com.gezhi.teamone.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gezhi.teamone.entity.Teacher;
import com.gezhi.teamone.service.TeacherService;
import com.gezhi.teamone.service.impl.TeacherServiceImpl;

public class TeacherServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		TeacherService service = new TeacherServiceImpl();
		PrintWriter out = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String url = req.getRequestURI();//得到前端传入的地址
		String path = url.substring(url.lastIndexOf("/") + 1, url.length());//得到除/前之后的地址字符串
		if ("findAllteacher".equals(path)) {
			String pagenow = req.getParameter("pagecurr");
			if (pagenow != null && pagenow.length() != 0) {
				int pagecurr = Integer.parseInt(pagenow);
				List<Teacher> teachers = service.findAllTeacher(pagecurr);
				String allteacher = mapper.writeValueAsString(teachers);
				out.print(allteacher);
			}else {
				out.print("-1");
			}

		} else if ("updateTeacher".equals(path)) {
			String teacherId = req.getParameter("teacherId");
			if (teacherId == null || teacherId.length() == 0) {
				out.print("-1");
			} else {
				int id = Integer.parseInt(teacherId);
				service.updateTeacherById(id);
				out.print("1");
			}
		} else if ("addTeacher".equals(path)) {
			String name = req.getParameter("tName");
			String gender = req.getParameter("tGender");
			String tel = req.getParameter("tTel");
			String address = req.getParameter("address");
			int sex = Integer.parseInt(gender);
			Teacher teacher = service.insertTeacher(name, sex, tel, address, null, null);
			if (teacher == null) {
				out.print("-1");
			} else {
				out.print("1");
			}
		} else if ("showTeacherInfo".equals(path)) {
			String id = req.getParameter("teacherId");
			if (id != null && id.length() != 0) {
				int teacherId = Integer.parseInt(id);
				Teacher tMsg = service.showMsgById(teacherId);
				String teacherInfo = mapper.writeValueAsString(tMsg);
				out.print(teacherInfo);
			} else {
				out.print("-1");
			}
		} else if ("getPageNum".equals(path)) {
			int allPageNums = service.getAllPageNums();
			if (allPageNums != 0) {
				out.print(allPageNums);
			} else {
				out.print("-100");
			}
		}

	}

}
