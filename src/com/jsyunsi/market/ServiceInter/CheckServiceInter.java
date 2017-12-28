package com.jsyunsi.market.ServiceInter;

/**
 * 用户登录检测接口
 * 
 * @author Administrator
 *
 */
public interface CheckServiceInter {

	/**
	 * 用户登录检查
	 * 
	 * @param user
	 *            用户名
	 * @param passwd
	 *            密码
	 * @return 1：用户名不存在；2：密码错误； 3：密码正确；0：方法没有正确执行
	 */
	int check(String user, String passwd);

}