package com.jsyunsi.market.DaoInter;

import com.jsyunsi.market.vo.Product;

/**
 * product操作接口
 * 
 * @author 紫风铃
 * @since 1.1
 */
public interface ProductDaoInter<E> extends DataInter<Product, E> {

	/**
	 * 更新库存
	 * 
	 * @param index
	 *            商品索引
	 * @param stock
	 *            商品新的库存
	 * @return true:更新成功
	 */
	boolean updateStock(E id, int stock);

	/**
	 * 更新商品价格
	 * 
	 * @param index
	 *            商品索引
	 * @param price
	 *            商品价格
	 * @return true:更新成功
	 */
	boolean updatePrice(E id, int price);

}