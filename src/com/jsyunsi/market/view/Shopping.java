package com.jsyunsi.market.view;

import java.util.ArrayList;
import java.util.Scanner;
import com.jsyunsi.market.Dao.ProductMysqlDao;
import com.jsyunsi.market.DaoInter.ProductDaoInter;
import com.jsyunsi.market.ServiceInter.SettleInter;
import com.jsyunsi.market.service.SettleService;
import com.jsyunsi.market.utils.SettleMessage;
import com.jsyunsi.market.utils.SettleRequest;
import com.jsyunsi.market.vo.Product;

public class Shopping {
	private Scanner scan = new Scanner(System.in);
	private boolean flag = true;
	ArrayList<Product> list = new ArrayList<>();
	ProductDaoInter productDaoInter = new ProductMysqlDao();
	SettleInter<SettleMessage, Product> settle = new SettleService();
	SettleMessage message = null;

	/**
	 * 是否使用折扣
	 * 
	 * @param dis
	 *            折扣
	 * @return 折扣值
	 */
	private double useDiscount(double dis) {
		while (true) {
			System.out.println("是否使用折扣？(Y/N)");
			switch (scan.next().toUpperCase()) {
			case "Y":
				System.out.println("折扣已使用！");
				return dis;
			case "N":
				System.out.println("未使用折扣！");
				return 1;
			default:
				System.out.println("输入错误，请重新输入：");
				break;
			}
		}
	}

	/**
	 * 是否继续
	 * 
	 * @return true:继续
	 */
	private boolean goNext() {
		while (true) {
			System.out.println("是否继续？(Y/N)");
			switch (scan.next().toUpperCase()) {
			case "Y":
				return true;
			case "N":
				return false;
			default:
				System.out.println("输入错误，请重新输入：");
				break;
			}
		}
	}

	/**
	 * 商品库存判断
	 * 
	 * @param product
	 *            商品
	 * @return true：库存充足
	 */
	private boolean stockCheck(Product product) {
		while (true) {
			System.out.println("请输入商品数量：");// --商品数量输入
			int quantity;
			try {
				quantity = scan.nextInt();
				if (quantity <= product.getStock()) {// --库存判断
					int index = list.indexOf(product);
					list.get(index).setStock(quantity);
					return true;
				} else {
					System.out.println("商品库存不足，请重新输入！");// 商品库存不足则重新输入
					System.out.println("当前库存：" + product.getStock());
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("输入格式错误！请重新输入");
				scan = new Scanner(System.in);
			}
		}
	}

	/**
	 * 结算金额计算
	 * 
	 * @param dis
	 *            折扣
	 */
	private void pay(double dis) {
		double amountPaid;
		while (true) {
			System.out.println("请输入实缴金额：");
			try {
				amountPaid = scan.nextDouble();
				SettleRequest<Product> settleRequest = new SettleRequest<>();
				settleRequest.setList(list);
				settleRequest.setDiscount(dis);
				settleRequest.setAmountPaid(amountPaid);
				message = settle.getSettleMessage(settleRequest);
				if (message.getChange() < 0) {// 判断实缴金额是否足够支付
					System.out.println("实缴金额不足，重新输入！");
					System.out.println("应付金额：" + message.getAmountPayable());
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("输入格式错误，请重新输入");
				scan = new Scanner(System.in);
				continue;
			}
		}
	}

	/**
	 * 打印小票
	 */
	private void printReceipt() {
		System.out.println("**************商品结算信息**************\n");
		System.out.println("商品总价：" + message.getTotal());
		System.out.println("购物折扣：" + message.getDiscount());
		System.out.println("应付金额：" + message.getAmountPayable());
		System.out.println("实缴金额：" + message.getAmountPaid());
		System.out.println("找零：" + message.getChange() + "\n");
		System.out.println("*************************************\n");
		System.out.println("程序结束，结算完成。");
	}

	/**
	 * 输入商品信息
	 */
	private void inputProduct() {
		flag = true;
		while (flag) {
			System.out.println("请输入商品编号：");// 结算商品输入
			try {
				int num = scan.nextInt();// 商品编号
				int id = productDaoInter.getId(num);
				if (productDaoInter.isExists(id)) {// 商品是否存在等信息查询及输出
					Product p1 = productDaoInter.getWithId(id);
					System.out.println("商品信息：\t" + "编号\t" + "名称\t" + "价格\t");
					System.out.println(p1.toString());// 打印商品信息
					list.add(p1);// 将结算商品添加到结算目录
					flag = false;
				} else {
					System.out.println("商品不存在!");// 商品不存在则重新输入商品信息
					flag = this.goNext();
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("输入格式错误！");
				scan = new Scanner(System.in);
				flag = this.goNext();
			}
		}
	}

	/**
	 * 结算界面
	 * 
	 * @param dis
	 *            折扣值
	 */
	public void settlement(double dis) {
		System.out.println("***************结算系统**************");
		System.out.println();
		System.out.println();
		System.out.println("***********************************");
		do {
			this.inputProduct();
			this.stockCheck(list.get(list.size() - 1));
		} while (this.goNext());
		double discount = this.useDiscount(dis);
		this.pay(discount);
		this.printReceipt();
		if (this.goNext()) {// 是否返回上一级
			Shopping shop = new Shopping();// 重新开始结算
			shop.settlement(dis);
		} else {
			System.out.println("退出成功！");
		}
	}
}
