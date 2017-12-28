package com.jsyunsi.market.view;

import java.util.Scanner;
import com.jsyunsi.market.service.LoginCheckService;

public class LoginView {
	private Scanner scan = new Scanner(System.in);

	//
	public void LoginShow() {
		System.out.println("**************天猫超市->登录系统***************");
		System.out.println("1. 登录");
		System.out.println("2. 退出");
		System.out.println("*******************************************");
		System.out.println("请选择，输入数字：");
	}

	// 退出判断
	public void exit() {
		System.out.println("是否退出？输入y确定，输入其他取消");
		if (scan.next().equalsIgnoreCase("y")) {
			System.out.println("退出成功!");
			System.exit(0);
		}
	}

	// 检测输入的选择
	public void jump() {
		while (true) {
			this.LoginShow();
			switch (scan.next()) {
			case "1":
				if (new LoginCheckService().Check()) {
					MenuView menu = new MenuView();// 登录MenuView
					menu.jump();
				} else {
					System.out.println("用户名或密码错误！");
				}
				break;
			case "2":
				this.exit();// 退出系统
				break;
			default:
				System.out.println("输入错误！");
				break;
			}
		}
	}
}
