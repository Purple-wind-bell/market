package com.jsyunsi.market.view;

import java.util.Scanner;

/**
 * 菜单
 * 
 * @author Administrator
 *
 */
public class MenuView {
	/** 商品折扣 */
	private double discount = 1;
	private Scanner scan = new Scanner(System.in);

	public void menu() {
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
			this.menu();
			switch (scan.next()) {
			case "1":
				CustView cust = new CustView();// 客户信息管理
				cust.jump();
				break;
			case "2":
				Shopping shop = new Shopping();
				shop.settlement(discount);// 购物结算
				break;
			case "3":
				GoodLuckView luckView = new GoodLuckView();
				this.discount = luckView.lotteryView();// 真情回馈"
				break;
			case "4":
				flag = false;// 注销,跳转start界面
				break;
			default:
				System.out.println("输入错误!");
				break;
			}

		}
	}
}
