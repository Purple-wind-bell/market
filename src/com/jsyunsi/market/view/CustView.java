package com.jsyunsi.market.view;

import java.util.Scanner;

import com.jsyunsi.market.ServiceInter.CustomerServiceInter;
import com.jsyunsi.market.service.CustomerService;

public class CustView {
	private Scanner scan = new Scanner(System.in);
	private CustomerServiceInter custService = new CustomerService();

	// 检测输入的选择
	public void jump() {
		boolean t = true;
		while (t) {
			System.out.println("************天猫超市->客户信息管理*************");
			System.out.println("1. 显示所有客户信息");
			System.out.println("2. 添加客户信息");
			System.out.println("3. 修改客户信息");
			System.out.println("4. 删除客户信息");
			System.out.println("5. 查询客户信息");
			System.out.println("******************************************");
			System.out.println("请选择，输入数字或按0返回上一级菜单：");
			switch (scan.next()) {
			case "1":
				custService.showAll();// 显示所有客户信息
				break;
			case "2":
				custService.add();// 添加客户信息
				break;
			case "3":
				custService.update();// 修改客户信息
				break;
			case "4":
				custService.del();// 删除客户信息
				break;
			case "5":
				custService.find();// 查询客户信息
				break;
			case "0":
				t = false;// 返回Menu界面
				break;
			default:
				System.out.println("输入错误，请重新输入");// 输入错误
				break;
			}
		}
	}
}
