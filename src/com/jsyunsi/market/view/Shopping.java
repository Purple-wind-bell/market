package com.jsyunsi.market.view;

import java.util.ArrayList;
import java.util.Scanner;
import com.jsyunsi.market.Dao.ProductDaoList;
import com.jsyunsi.market.DaoInter.ProductDaoInter;
import com.jsyunsi.market.vo.Product;

public class Shopping {
	private Scanner scan = new Scanner(System.in);
	private int quantity;// 商品数量
	private double total;// 总价
	private double discount;// 折扣
	private int amountPayable;// 应付金额,取整
	private double amountPaid;// 实缴金额
	private double change;// 找零
	int index;
	private int num;// 商品编号
	private double price;// 商品价格
	private int stock;// 商品库存
	@SuppressWarnings("unused")
	private String name;// 商品名称
	private boolean flag = true;//
	private static Shopping shop = new Shopping();
	ProductDaoInter productDaoInter = new ProductDaoList();

	// 获得shop对象
	public static Shopping getShopping() {
		return shop;
	}

	// 显示结算系统界面
	private void display() {
		System.out.println("***************结算系统**************");
		System.out.println();
		System.out.println("商品编号\t商品名称\t\t商品价格\t\t商品库存");
		ArrayList<Product> prolist = productDaoInter.getList();
		for (int i = 0; i < productDaoInter.getAmount(); i++) {
			System.out.println(prolist.get(i).toString());
		}
		System.out.println();
		System.out.println("***********************************");
	}

	// 折扣使用
	private void useDiscount(double dis) {
		boolean t = true;
		while (t) {
			System.out.println("是否使用折扣？(y/n)");
			switch (scan.next()) {
			case "y":
				this.discount = dis;
				System.out.println("折扣已使用！");
				t = false;
				break;
			case "n":
				this.discount = 1;
				System.out.println("未使用折扣！");
				t = false;
				break;
			default:
				System.out.println("输入错误");
				break;
			}
		}
	}

	// 是否继续
	private boolean next() {
		while (true) {
			System.out.println("是否继续？(y/n)");
			switch (scan.next()) {
			case "y":
				return true;
			case "n":
				return false;
			default:
				System.out.println("输入错误，请重新输入：");
				break;
			}
		}
	}

	// 获得并打印商品信息
	private void printInformation() {
		Product pro = productDaoInter.getProductWithIndex(this.index);
		this.name = pro.getName();// 获得商品信息
		this.price = pro.getPrice();
		this.stock = pro.getStock();
		// 打印商品信息
		System.out.println("商品信息：\t" + "编号\t" + "名称\t" + "价格\t");
		System.out.println(pro.toString());
	}

	// 空库存判断
	@SuppressWarnings("unused")
	private boolean isEmptyStock() {
		if (this.stock == 0) {
			System.out.println("该商品零库存");
			return true;
		} else {
			return false;
		}
	}

	// 商品库存判断
	private boolean stockCheck() {
		// --商品数量输入
		while (true) {
			System.out.println("请输入商品数量：");
			try {
				this.quantity = scan.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("输入格式错误！请重新输入");
				scan = new Scanner(System.in);
				continue;
			}

			// --库存判断
			if (this.quantity <= this.stock) {
				this.total += this.quantity * this.price;// 计算总价
				return true;
			} else {
				System.out.println("商品库存不足，请重新输入！");// 商品库存不足则重新输入
				System.out.println("当前库存：" + this.stock);
			}
		}
	}

	// 结算金额计算
	private void Cal() {
		this.amountPayable = (int) (this.discount * this.total);// 应付金额
		while (true) {
			System.out.println("请输入实缴金额：");
			try {
				this.amountPaid = scan.nextDouble();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("输入格式错误，请重新输入");
				scan = new Scanner(System.in);
				continue;
			}
			//
			this.change = this.amountPaid - this.amountPayable;// 找零
			if (this.change < 0) {// 判断实缴金额是否足够支付
				System.out.println("实缴金额不足，重新输入！");
				System.out.println("应付金额：" + this.amountPayable);
			} else {
				break;
			}
		}
	}

	// 打印小票
	private void printReceipt() {
		System.out.println("**************商品结算信息**************\n");
		System.out.println("商品总价：" + this.total);
		System.out.println("购物折扣：" + this.discount);
		System.out.println("应付金额：" + this.amountPayable);
		System.out.println("实缴金额：" + this.amountPaid);
		System.out.println("找零：" + this.change + "\n");
		System.out.println("*************************************\n");
		System.out.println("程序结束，结算完成。");
	}

	// 是否返回上一级
	private void comeBack() {
		if (this.next()) {
			Shopping shop = new Shopping();// 重新开始结算
			shop.settlement(this.discount);
		} else {
			System.out.println("退出成功！");
		}
	}

	private void enterProduct() {
		this.flag = true;
		while (this.flag) {
			// 结算商品输入
			System.out.println("请输入商品编号：");
			try {
				this.num = scan.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("输入格式错误！");
				scan = new Scanner(System.in);
				this.flag = this.next();
				continue;
			}

			// -------
			index = productDaoInter.getIndex(num);
			if (productDaoInter.isExists(index)) {// 商品是否存在等信息查询及输出
				this.printInformation();
				break;
			} else {
				System.out.println("商品不存在!");// 商品不存在则重新输入商品信息
				this.flag = this.next();
			}
		}
	}

	// 结算
	public void settlement(double discount) {
		this.display();
		do {
			this.enterProduct();
			this.stockCheck();
		} while (this.next());
		// 折扣
		this.useDiscount(discount);
		this.Cal();
		this.printReceipt();
		this.comeBack();
	}
}
