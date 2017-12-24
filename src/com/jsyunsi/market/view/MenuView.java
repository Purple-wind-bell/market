package com.jsyunsi.market.view;

import java.util.Scanner;
import com.jsyunsi.market.service.GoodLuckService;

public class MenuView {
	private Scanner scan = new Scanner(System.in);
	private double discount = 1;// 商品折扣

	public void Menu() {
		System.out.println("************天猫超市->购物管理系统*************");
		System.out.println("1. 客户信息管理");
		System.out.println("2. 购物结算");
		System.out.println("3. 真情回馈");
		System.out.println("4. 注销");
		System.out.println("******************************************");
		System.out.println("请选择，输入数字：");
	}

	// 检测输入的选择
	public void jump() {
		boolean flag = true;
		while (flag) {
			this.Menu();
			// int key = scan.nextInt();
			// if (key == 4) {// 注销,跳转start界面
			// System.out.println("注销成功");
			// break;
			// }
			// switch (key) {
			switch (scan.next()) {
			case "1":
				CustView cust = new CustView();// 客户信息管理
				cust.jump();
				break;
			case "2":
				// Shopping shop = new Shopping();
				// shop.settlement(discount);
				Shopping.getShopping().settlement(discount);// 购物结算
				break;
			case "3":
				GoodLuckService luck = new GoodLuckService();// 真情回馈"
				this.discount = luck.lottery();
				break;
			case "4":
				// Start start = new Start();// 注销,跳转start界面
				flag = false;
				break;
			default:
				System.out.println("输入错误!");
				break;
			}

		}
	}
}
