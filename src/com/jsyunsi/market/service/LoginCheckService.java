package com.jsyunsi.market.service;

import com.jsyunsi.market.serviceInter.CheckServiceInter;
import com.jsyunsi.market.vo.Admin;

/**
 * 用户登录检测实现
 * 
 * @author Administrator
 *
 */
public class LoginCheckService implements CheckServiceInter {
	private Admin admin = new Admin();

	@Override
	public int check(String user, String passwd) {
		// --密码对错判断
		int status = 0;
		if (user.equals(admin.getUser())) {
			if (passwd.equals(admin.getPasswd())) {
				status = 3;// 密码正确
			} else {
				status = 2;// 密码错误
			}
		} else {
			status = 1;
		}
		return status;
	}
}