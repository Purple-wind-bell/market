package com.jsyunsi.market.vo;

import java.io.Serializable;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 客户属性 */
	/** 卡号 */
	private int cardNum;
	/** 姓名 */
	private String name;
	/** 手机 */
	private String phone;

	/**
	 * 构造函数
	 */
	public Customer() {
	}

	/**
	 * 构造函数
	 * 
	 * @param cardNum
	 *            卡号
	 * @param name
	 *            用户姓名
	 * @param phone
	 *            用户手机号
	 */
	public Customer(int cardNum, String name, String phone) {
		this.cardNum = cardNum;
		this.name = name;
		this.phone = phone;
	}

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCustomer(int cardNum, String name, String phone) {
		this.cardNum = cardNum;
		this.name = name;
		this.phone = phone;
	}

	@Override
	public boolean equals(Object customer) {
		if (this == customer) {
			return true;
		}
		if (customer == null || getClass() != customer.getClass()) {
			return false;
		}
		Customer cust = (Customer) customer;
		return this.cardNum == cust.cardNum;
	}

	@Override
	public String toString() {
		return "[ cardNum = " + this.cardNum + "	name = " + this.name + "	phone = " + this.phone + " ]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
