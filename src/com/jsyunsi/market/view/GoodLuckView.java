package com.jsyunsi.market.view;

import java.util.Scanner;

import com.jsyunsi.market.ServiceInter.GoodLuckServiceInter;
import com.jsyunsi.market.service.GoodLuckService;

/**
 * 抽奖界面
 * 
 * @author Administrator
 *
 */
public class GoodLuckView {
	/** 折扣值 */
	private double discount;
	private GoodLuckServiceInter luckService = new GoodLuckService();

	/**
	 * 抽奖界面
	 * 
	 * @return 折扣值
	 */
	@SuppressWarnings("resource")
	public double lotteryView() {
		Scanner scan = new Scanner(System.in);
		System.out.println("****************抽奖系统**************");
		boolean t = true;
		while (t) {
			System.out.println("是否开始抽奖？(y/n)");
			System.out.println();
			System.out.println("************************************");
			String input = scan.next();
			switch (input.toUpperCase()) {
			case "Y":
				discount = luckService.lottery(true);// 生成幸运值
				if (discount < 0.7) {
					System.out.println("谢谢惠顾");
				} else {
					System.out.println("您的折扣为" + discount);
				}
				break;
			case "N":
				t = false;
				break;
			default:
				System.out.println("输入错误，请重新输入");
				break;
			}
		}
		return discount;
	}
}
