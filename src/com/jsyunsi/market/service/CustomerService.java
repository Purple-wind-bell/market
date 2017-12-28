package com.jsyunsi.market.service;

import java.util.Scanner;
import com.jsyunsi.market.Dao.CustomerDaoList;
import com.jsyunsi.market.DaoInter.CustomerDaoInter;
import com.jsyunsi.market.serviceInter.CustomerServiceInter;
import com.jsyunsi.market.vo.Customer;

//public class CustomerService extends CustomerIO {
public class CustomerService implements CustomerServiceInter {
	private CustomerDaoInter custInter = new CustomerDaoList();
	Scanner scan = new Scanner(System.in);

	/**
	 * 检测输入卡号
	 * 
	 * @return 卡号 ， -1表示输入错误
	 */
	private int input() {
		int num = -1;
		boolean flag = true;
		while (flag) {
			try {
				System.out.println("请输入客户卡号：");
				num = scan.nextInt();
				flag = false;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("输入格式错误！");
				scan = new Scanner(System.in);
			}
		}
		return num;
	}

	@Override
	public void showAll() {
		System.out.println("卡号\t姓名\t手机");
		for (int i = 0; i < custInter.getAmount(); i++) { // 遍历打印所有客户信息
			System.out.println(custInter.getWithIndex(i).toString());
		}
	}

	private void showById(int num) {
		System.out.println("卡号\t姓名\t手机");
		Customer cust = custInter.getWithIndex(custInter.getIndex(num));
		System.out.println(cust.toString());
	}

	@Override
	public void add() {
		System.out.println("当前用户数：" + custInter.getAmount());
		int num = this.input();
		if (custInter.isExists(num)) {// 判断该用户是否已经存在
			System.out.println("该卡号不存在用户，可以添加。");// 不存在
			System.out.println("请输入姓名：");
			String name = scan.next();
			System.out.println("请输入电话：");
			String phone = scan.next();
			Customer cust = new Customer(num, name, phone);
			if (custInter.add(cust)) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
		} else {
			System.out.println("该客户已存在！");
		}
	}

	@Override
	public void find() {
		System.out.println("请输入客户卡号：");// 查询该客户是否存在
		int num = this.input();
		if (custInter.isExists(num)) {// 若存在,显示信息
			System.out.println("查询的客户存在！");
			this.showById(num);
		} else {
			System.out.println("查询的客户不存在！");// 不存在则输出警告
		}
	}

	@Override
	public void update() {
		System.out.println("请输入客户卡号：");
		int num = this.input();
		if (custInter.isExists(num)) {// 判断该用户是否已经存在
			this.showById(num);
			System.out.println("该卡号存在用户，可以修改。");// 存在
			System.out.println("请输入姓名：");
			String name = scan.next();
			System.out.println("请输入电话：");
			String phone = scan.next();
			Customer cust = new Customer(num, name, phone);
			if (custInter.update(num, cust)) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} else {
			System.out.println("该客户不存在！");
		}
	}

	@Override
	public void del() {
		System.out.println("请输入客户卡号：");
		int num = this.input();
		int index = custInter.getIndex(num);
		if (custInter.isExists(index)) {// 判断该用户是否已经存在
			System.out.println("卡号\t姓名\t手机");
			System.out.println(custInter.getWithIndex(index).toString());
			System.out.println("是否确认删除？(y/n)");// 存在,判断是否删除
			switch (scan.next().toUpperCase()) {
			case "Y":
				if (custInter.delWithIndex(index)) {
					System.out.println("删除成功");
				} else {
					System.out.println("删除失败");
				}
				break;
			case "N":
				System.out.println("不删除，退出");
				break;
			default:
				System.out.println("输入错误，请重新输入：");
				break;
			}
		} else {
			System.out.println("该客户不存在！");
		}
	}
}
