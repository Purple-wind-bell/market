package com.jsyunsi.market.service;

import java.util.ArrayList;
import java.util.Iterator;
import com.jsyunsi.market.serviceInter.SettleInter;
import com.jsyunsi.market.vo.Product;
import com.jsyunsi.market.vo.SettleMessage;

/**
 * 结算服务
 * 
 * @author 紫风铃
 *
 * @param <K>
 *            存储单一商品信息的数据类型
 * @param <V>
 *            单一商品的数量的数据类型
 */
public class SettleService implements SettleInter<SettleMessage, Product> {

	@Override
	public SettleMessage getSettleMessage(ArrayList<Product> list, double amountPaid, double discount) {
		// TODO Auto-generated method stub
		/** 总价 */
		double total = 0;
		/** 应付金额 */
		double amountPayable;
		/** 找零 */
		double change;

		Iterator<Product> iterator = list.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			total = product.getPrice() * product.getStock();
		}
		amountPayable = total * discount;
		change = amountPaid - amountPayable;
		return new SettleMessage(total, discount, amountPayable, amountPaid, change);
	}

}