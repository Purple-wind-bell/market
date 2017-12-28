package com.jsyunsi.market.vo;

public class Product {
	/** 商品属性 */
	/** 编号 */
	private int num;
	/** 名称 */
	private String name;
	/** 价格 */
	private double price;
	/** 库存 */
	private int stock;

	/**
	 * 构造函数
	 */
	public Product() {
	}

	public Product(int num, String name, double price, int stock) {
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
	public boolean equals(Object product) {
		if (this == product) {
			return true;
		}
		if (product == null || getClass() != product.getClass()) {
			return false;
		}
		Product cust = (Product) product;
		return this.num == cust.num;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "[ num = " + this.num + "	name = " + this.name + "	price = " + this.price + "	stock = "
				+ this.stock + " ]";
	}
}