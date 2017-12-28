package com.jsyunsi.market.utils;

import java.util.ArrayList;

public class SettleRequest<E> {
	/** 商品集合 */
	ArrayList<E> list;
	/** 实缴金额 */
	double amountPaid;
	/** 折扣 */
	double discount;

	public SettleRequest() {
		super();
	}

	public ArrayList<E> getList() {
		return list;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public double getDiscount() {
		return discount;
	}

	public void setList(ArrayList<E> list) {
		this.list = list;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
