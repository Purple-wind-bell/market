package com.jsyunsi.market.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.jsyunsi.market.Dao.ProductMysqlDao;
import com.jsyunsi.market.DaoInter.ProductDaoInter;
import com.jsyunsi.market.ServiceInter.SettleInter;
import com.jsyunsi.market.utils.SettleMessage;
import com.jsyunsi.market.utils.SettleRequest;
import com.jsyunsi.market.vo.Product;

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
	ProductDaoInter proInter = new ProductMysqlDao();

	@Override
	public SettleMessage getSettleMessage(SettleRequest<Product> settleRequest) {
		// TODO Auto-generated method stub
		/** 总价 */
		double total = 0;
		/** 应付金额 */
		double amountPayable;
		/** 找零 */
		double change;
		// 获取参数
		ArrayList<Product> list = settleRequest.getList();// 结算商品列表
		double amountPaid = settleRequest.getAmountPaid();// 实缴金额
		double discount = settleRequest.getDiscount();// 折扣
		Iterator<Product> iterator = list.iterator();
		// 计算商品列表总价
		while (iterator.hasNext()) {
			Product product = iterator.next();
			total = product.getPrice() * product.getStock();
		}
		amountPayable = total * discount;// 应付金额
		change = amountPaid - amountPayable;// 找零
		if (change >= 0) {
			while (iterator.hasNext()) {
				Product product = iterator.next();
				int id = product.getNum();
				int stock = proInter.getWithId(id).getStock() - product.getStock();
				proInter.updateStock(id, stock);
			}

		}

		return new SettleMessage(total, discount, amountPayable, amountPaid, change);
	}

}
