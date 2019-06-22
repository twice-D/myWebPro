package com.gezhi.teamone.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
		String url = req.getRequestURI();// 得到前端传入的地址
		String path = url.substring(url.lastIndexOf("/") + 1, url.length());// 得到除/前之后的地址字符串
		if ("findAllteacher".equals(path)) {
			String pagenow = req.getParameter("pagecurr");
			if (pagenow != null && pagenow.length() != 0) {
				int pagecurr = Integer.parseInt(pagenow);
				List<Teacher> teachers = service.findAllTeacher(pagecurr);
				String allteacher = mapper.writeValueAsString(teachers);
				out.print(allteacher);
			} else {
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
		} else if ("upload".equals(path)) {
			// 工厂类实例
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");
			// 解析请求参数
			try {
				List<FileItem> items = upload.parseRequest(req);
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
					ServletContext sc = getServletContext();
					String stpath = sc.getRealPath("/upload");
					System.out.println(stpath);
					// 获得文件名
					String FileName = item.getName();
					File file = new File(stpath + "\\" + FileName);
					String imageUrl = "upload" + "\\" + FileName;
					item.write(file);
					service.changeImagByName(imageUrl, "小凉");
					System.out.println(imageUrl);
					out.print(imageUrl);
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("-100");// 图片上传失败
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("-1");// 服务器异常

			} finally {
				resp.sendRedirect("teacherManager.html");
			}
		} else if ("changInfo".equals(path)) {
			String userName = req.getParameter("name");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			if (userName == null || userName.length()==0) {
				out.print("-100");// 用户没输入
			} else if(phone == null || phone.length()==0){
				out.print("-100");// 用户没输入
			}else if(address==null || address.length()==0){
				out.print("-100");// 用户没输入
			}else {
				service.changUserInfoByName(userName, phone, address, "");
				out.print("1");
			}

		} else if ("getImageUrlByName".equals(path)) {
			String imageUrl = service.getUrlByName("张三");
			if (imageUrl == null || imageUrl.length() == 0) {
				out.print("-1");
			} else {
				out.print(imageUrl);
			}
		}

	}

}
