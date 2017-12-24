package com.jsyunsi.market.vo;

import java.io.Serializable;

public class CustomerData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 客户属性
	private int cardNum;// 卡号
	private String name;// 姓名
	private String phone;// 手机

	// 构造函数
	public CustomerData() {
	}

	public CustomerData(int cardNum, String name, String phone) {
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

	public void setCustomerData(int cardNum, String name, String phone) {
		this.cardNum = cardNum;
		this.name = name;
		this.phone = phone;
	}

	public boolean equals(int cardNum) {
		if (this.cardNum == cardNum) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ cardNum = " + this.cardNum + "	name = " + this.name
				+ "	phone = " + this.phone + " ]";
	}

	public String toStringLite() {
		// TODO Auto-generated method stub
		return this.cardNum + "\t" + this.name + "\t" + this.phone;
	}

}
