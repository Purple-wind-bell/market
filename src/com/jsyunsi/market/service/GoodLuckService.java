package com.jsyunsi.market.service;

import java.util.Scanner;

public class GoodLuckService {
	// 属性
	private double dis;

	// 抽奖方法
	public double lottery() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("****************抽奖系统**************");
		boolean t = true;
		while (t) {
			System.out.println("是否开始抽奖？(y/n)");
			System.out.println();
			System.out.println("************************************");
			switch (scan.next()) {
			case "y":
				double luckValue = Math.random();// 生成幸运值
				if (luckValue < 0.7) {
					dis = 1;
					System.out.println("谢谢惠顾");
				} else {
					dis = luckValue;
					System.out.println("您的折扣为" + dis);
				}
				break;
			case "n":
				t = false;
				break;
			default:
				System.out.println("输入错误，请重新输入");
				break;
			}
		}
		return dis;
	}

}
