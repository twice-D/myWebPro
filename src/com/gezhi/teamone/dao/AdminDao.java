package com.gezhi.teamone.dao;

import com.gezhi.teamone.entity.Admin;

public interface AdminDao {

	/**
	 * 添加管理员
	 * 默认账号：gezhi xxx
	 * 密码:123456
	 * @return
	 * @throws Exception 
	 */
	public void insertAdmin() throws Exception;
	/**
	 * 修改管理员账号
	 * @param oldtName
	 * @param newtName
	 * @return
	 * @throws Exception
	 */
	int setAdminNames(String oldtName, String newtName) throws Exception;
	/**
	 * 实现登录
	 * @param uName
	 * @param uPwd
	 * @return
	 * @throws Exception
	 */
	String login(String uName, String uPwd) throws Exception;
	/**
	 * 修改管理员密码
	 * @param oldtName
	 * @param tPwd
	 * @param newtPwd
	 * @return
	 * @throws Exception
	 */
	public int setAdminPwd(String oldtName, String tPwd, String newtPwd) throws Exception;
	
}
