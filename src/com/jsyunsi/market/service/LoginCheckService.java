package com.jsyunsi.market.service;

import java.util.Scanner;
import com.jsyunsi.market.vo.AdminData;

public class LoginCheckService {
	private Scanner scan = new Scanner(System.in);
	private AdminData admin = new AdminData();
	private static int errorCount = 0;

	// 登录判断
	public boolean Check() {
		System.out.println("请输入用户名:");
		String user = scan.next();
		System.out.println("请输入密码:");
		String passwd = scan.next();

		// --密码对错判断
		if (user.equals(admin.getUser()) && passwd.equals(admin.getPasswd())) {
			return true;// 密码正确
		} else {
			errorCount++;// 密码错误
			if (errorCount != 3) { // 第三次输入错误不显示剩余次数
				System.out.println("剩余次数：" + (3 - errorCount));
			} else {
				System.out.println("密码错误3次！稍后再试");
				errorCount = 0;
				try {
					Thread.sleep(5000);// 程序休眠5秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return false;
		}
	}
}