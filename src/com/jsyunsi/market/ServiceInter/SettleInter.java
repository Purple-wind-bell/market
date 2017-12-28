package com.jsyunsi.market.ServiceInter;

import java.util.ArrayList;

/**
 * 结算接口
 * 
 * @author 紫风铃
 *
 * @param <T>
 *            结算完成后产生的结果，以对象形式返回
 * @param <E>
 *            要结算的产品的类型
 */
public interface SettleInter<T, E> {

	/**
	 * 结算方法
	 * 
	 * @param list
	 *            产品集合
	 * @param amountPaid
	 *            实缴金额
	 * @param discount
	 *            折扣
	 * @return T
	 */
	T getSettleMessage(ArrayList<E> list, double amountPaid, double discount);

}
