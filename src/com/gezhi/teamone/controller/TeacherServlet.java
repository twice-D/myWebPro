package com.gezhi.teamone.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
//		Cookie[] cookies = req.getCookies();//得到cookie数组
//		String porname = "";
//		if(cookies[0].getName()=="teacher") {
//			porname = cookies[0].getValue();
//		}
		HttpSession session = req.getSession();
		String  porname = (String) session.getAttribute("teacher");
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		TeacherService service = new TeacherServiceImpl();
		PrintWriter out = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String url = req.getRequestURI();// 得到前端传入的地址
		String path = url.substring(url.lastIndexOf("/") + 1, url.length());// 得到除/前之后的地址字符串
		//查询出所有老师信息
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
			//修改信息(软删除该教师)
		} else if ("updateTeacher".equals(path)) {
			String teacherId = req.getParameter("teacherId");
			if (teacherId == null || teacherId.length() == 0) {
				out.print("-1");
			} else {
				int id = Integer.parseInt(teacherId);
				service.updateTeacherById(id);
				out.print("1");
			}
			//添加老师信息（地址栏可以选填）
		} else if ("addTeacher".equals(path)) {
			String name = req.getParameter("tName");
			String gender = req.getParameter("tGender");
			String tel = req.getParameter("tTel");
			String address = req.getParameter("address");
			int sex = Integer.parseInt(gender);
			if (name == null || name.length() == 0) {
				out.print("-100");
			} else if (gender == null || gender.length() == 0) {
				out.print("-100");
			} else if (tel == null || tel.length() == 0) {
				out.print("-100");
			} else {
				Teacher teacher = service.insertTeacher(name, sex, tel, address, null, null);
				if (teacher == null) {
					out.print("-1");
				} else {
					out.print("1");
				}
			}
			//显示老师详细信息
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
			//得到总页数
		} else if ("getPageNum".equals(path)) {
			int allPageNums = service.getAllPageNums();
			if (allPageNums != 0) {
				out.print(allPageNums);
			} else {
				out.print("-100");
			}
			//上传头像
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
					service.changeImagByName(imageUrl, "小凉");//通过cookie得到当前名字
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
				resp.sendRedirect("../changeProMsg.html");
			}
			//修改个人信息
		} else if ("changInfo".equals(path)) {
			String userName = req.getParameter("name");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			if (phone == null || phone.length() == 0) {
				out.print("-100");// 用户没输入
			} else if (address == null || address.length() == 0) {
				out.print("-100");// 用户没输入
			} else {
				// 如果管理员不修改自己姓名（在姓名框不输入）则姓名这一参数还是原姓名，不做修改。
				if (userName == null || userName.length() == 0) {
					service.changUserInfoByName(porname, phone, address, porname);
					out.print("1");//修改成功
				} else {
					service.changUserInfoByName(userName, phone, address, porname);
					out.print("1");
				}
			}
         //通过姓名查询出该用户照片存储的名字（方便修改头像）
		} else if ("getImageUrlByName".equals(path)) {
			String imageUrl = service.getUrlByName("");
			if (imageUrl == null || imageUrl.length() == 0) {
				out.print("-1");
			} else {
				out.print(imageUrl);
			}
		} else if ("findMsgByCase".equals(path)) {
			String strName = req.getParameter("strname");
			List<Teacher> list = service.findAllTeacherByInput(strName);
			//如果没有查询出来这个用户，则提示没有该用户
		    if(strName == null || strName.length()==0){
				out.print("-1");
			}else if(list == null || list.size() == 0){
				out.print("0");
			}else {
				String show = mapper.writeValueAsString(list);
				out.print(show);
			}
		}

	}

}
