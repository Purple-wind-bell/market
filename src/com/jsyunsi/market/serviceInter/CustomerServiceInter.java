package com.jsyunsi.market.serviceInter;

public interface CustomerServiceInter {

	/**
	 * 显示所有客户信息
	 */
	void showAll();

	/**
	 * 添加用户
	 */
	void add();

	/**
	 * 查询指定客户信息并显示
	 */
	void find();

	/**
	 * 更改用户
	 */
	void update();

	/**
	 * 删除用户
	 */
	void del();

}