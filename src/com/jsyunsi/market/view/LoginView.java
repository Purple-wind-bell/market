package com.jsyunsi.market.view;

import java.util.Scanner;

import com.jsyunsi.market.ServiceInter.CheckServiceInter;
import com.jsyunsi.market.service.LoginCheckService;

/**
 * 登录界面
 * 
 * @author Administrator
 *
 */
public class LoginView {
	private Scanner scan = new Scanner(System.in);
	/** 错误次数 */
	private int wrongNum = 0;
	private boolean t = true;
	private CheckServiceInter check = new LoginCheckService();

	/**
	 * 登录
	 */
	private void login() {
		System.out.println("请输入用户名:");
		String user = scan.next();
		System.out.println("请输入密码:");
		String passwd = scan.next();
		int status = check.check(user, passwd);// 获得用户检查结果状态码
		if (status == 3) {
			MenuView menu = new MenuView();// 登录MenuView
			menu.jump();
		} else {
			System.out.println("用户名或密码错误！");
			wrongNum++;
			this.wrongCheck();
		}
	}

	/**
	 * 错误次数检测
	 */
	private void wrongCheck() {
		if (wrongNum != 3) { // 第三次输入错误不显示剩余次数
			System.out.println("剩余次数：" + (3 - wrongNum));
		} else {
			wrongNum = 0;
			try {
				System.out.println("锁定5秒！");
				Thread.sleep(5000);// 程序休眠5秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 检测输入的选择
	 * 
	 */
	public void jump() {
		t = true;
		System.out.println("**************天猫超市->登录系统***************");// 登录界面显示
		System.out.println("1. 登录");
		System.out.println("2. 退出");
		System.out.println("*******************************************");
		System.out.println("请选择，输入数字：");
		while (t) {
			switch (scan.next()) {
			case "1":
				this.login();
				break;
			case "2":
				System.out.println("是否退出？输入y确定，输入其他取消");// 退出判断
				if (scan.next().equalsIgnoreCase("y")) {
					t = false;// 退出系统
				}
				break;
			default:
				System.out.println("输入错误！");
				break;
			}
		}
		System.out.println("退出成功!");
	}
}
