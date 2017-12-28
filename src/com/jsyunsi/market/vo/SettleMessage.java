package com.jsyunsi.market.vo;

public class SettleMessage {
	/** 总价 */
	private double total;
	/** 折扣 */
	private double discount;
	/** 应付金额 */
	private double amountPayable;
	/** 实缴金额 */
	private double amountPaid;
	/** 找零 */
	private double change;

	public SettleMessage(double total, double discount, double amountPayable, double amountPaid, double change) {
		super();
		this.total = total;
		this.discount = discount;
		this.amountPayable = amountPayable;
		this.amountPaid = amountPaid;
		this.change = change;
	}

	public double getTotal() {
		return total;
	}

	public double getDiscount() {
		return discount;
	}

	public double getAmountPayable() {
		return amountPayable;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public double getChange() {
		return change;
	}

}
