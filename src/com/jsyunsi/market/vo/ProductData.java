package com.jsyunsi.market.vo;

public class ProductData {
	// 商品属性
	private int num;// 编号
	private String name;// 名称
	private double price;// 价格
	private int stock;// 库存

	// 构造函数
	public ProductData() {
	}

	public ProductData(int num, String name, double price, int stock) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean equals(int num) {
		if (this.num == num) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() 显示全部属性
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return "[ num = " + this.num + "\tname = " + this.name + "\tprice = "
				+ this.price + "\tstock = " + this.stock + " ]";
	}

	public String toStringLite() {
		// TODO Auto-generated method stub
		return (this.num + "\t" + this.name + "\t\t" + this.price + "\t\t" + this.stock);
	}
}