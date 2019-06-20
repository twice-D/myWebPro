package com.gezhi.teamone.dao;

import com.gezhi.teamone.entity.Admin;

public interface AdminDao {

	/**
	 * 添加管理员
	 * 默认账号：gezhi xxx
	 * 密码:123456
	 * @return
	 */
	public void insertAdmin();
	/**
	 * 实现登录，根据账号密码查询数据库，返回Admin对象
	 * 判断是否为空，为空说明该用户不存在
	 * @return
	 */
	public Admin selectAdmin(Integer adminId);
}
