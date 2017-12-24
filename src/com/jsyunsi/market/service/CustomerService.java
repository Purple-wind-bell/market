package com.jsyunsi.market.service;

import java.util.Scanner;
import com.jsyunsi.market.Dao.CustomerDaoList;
import com.jsyunsi.market.DaoInter.CustomerDaoInter;
import com.jsyunsi.market.vo.CustomerData;

//public class CustomerService extends CustomerIO {
public class CustomerService {
	private CustomerDaoInter custInter = new CustomerDaoList();
	Scanner scan = new Scanner(System.in);
	private boolean flag = true;
	private int cardNum;
	private String name;
	private String phone;

	// 是否继续
	private void next() {
		boolean t = true;
		while (t) {
			System.out.println("是否继续？(y/n)");
			switch (scan.next()) {
			case "y":
				this.flag = true;
				t = false;
				break;
			case "n":
				this.flag = false;
				t = false;
				break;
			default:
				System.out.println("输入错误，请重新输入：");
				t = true;
				break;
			}
		}
	}

	private void input() {
		// 检测输入卡号
		System.out.println("请输入客户卡号：");
		try {
			this.cardNum = scan.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("输入格式错误！");
			this.next();
		}
	}

	// 显示所有客户信息
	public void showAll() {
		System.out.println("卡号\t姓名\t手机");
		for (int i = 0; i < custInter.getAmount(); i++) { // 遍历打印所有客户信息
			System.out.println(custInter.getCustomerWithIndex(i).toStringLite());
		}
	}

	private void showById(int cardNum) {
		System.out.println("卡号\t姓名\t手机");
		System.out.println(custInter.getCustomerWithIndex(custInter.getIndex(cardNum)).toStringLite());
	}

	public void add() {
		this.flag = true;
		while (this.flag) {
			System.out.println("当前用户数：" + custInter.getAmount());
			this.input();
			// --------------
			if (!custInter.Exists(this.cardNum)) {// 判断该用户是否已经存在
				System.out.println("该卡号不存在用户，可以添加。");// 不存在
				System.out.println("请输入姓名：");
				this.name = scan.next();
				System.out.println("请输入电话：");
				this.phone = scan.next();
				if (custInter.add(new CustomerData(cardNum, name, phone))) {
					System.out.println("添加成功");
				} else {
					System.out.println("添加失败");
				}
			} else {
				System.out.println("该客户已存在！");
			}
			this.next();
		}
	}

	// 查询指定客户信息并显示
	public void find() {
		this.flag = true;
		while (flag) {
			System.out.println("请输入客户卡号：");// 查询该客户是否存在
			this.input();
			if (custInter.Exists(this.cardNum)) {// 若存在,显示信息
				System.out.println("查询的客户存在！");
				this.showById(this.cardNum);
			} else {
				System.out.println("查询的客户不存在！");// 不存在则输出警告
			}
			this.next();
		}
	}

	public void update() {
		this.flag = true;
		while (this.flag) {
			System.out.println("请输入客户卡号：");
			this.input();
			if (custInter.Exists(this.cardNum)) {// 判断该用户是否已经存在
				this.showById(this.cardNum);
				System.out.println("该卡号存在用户，可以修改。");// 存在
				System.out.println("请输入姓名：");
				this.name = scan.next();
				System.out.println("请输入电话：");
				this.phone = scan.next();
				if (custInter.update(this.cardNum, this.name, this.phone)) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败");
				}
			} else {
				System.out.println("该客户不存在！");
			}
			this.next();
		}
	}

	public void del() {
		this.flag = true;
		while (this.flag) {
			System.out.println("请输入客户卡号：");
			this.input();
			int index = custInter.getIndex(this.cardNum);
			if (custInter.Exists(index)) {// 判断该用户是否已经存在
				System.out.println("卡号\t姓名\t手机");
				System.out.println(custInter.getCustomerWithIndex(index).toStringLite());
				// 存在,判断是否删除
				System.out.println("是否确认删除？(y/n)");
				switch (scan.next()) {
				case "y":
					if (custInter.delWithIndex(index)) {
						System.out.println("删除成功");
					} else {
						System.out.println("删除失败");
					}
					break;
				case "n":
					System.out.println("不删除，退出");
					flag = false;
					break;
				default:
					System.out.println("输入错误，请重新输入：");
					break;
				}
			} else {
				System.out.println("该客户不存在！");
			}
			this.next();
		}
	}

}
