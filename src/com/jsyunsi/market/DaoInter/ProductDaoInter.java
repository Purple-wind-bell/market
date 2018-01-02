package com.jsyunsi.market.DaoInter;

import com.jsyunsi.market.vo.Product;

/**
 * product操作接口
 * 
 * @author 紫风铃
 */
public interface ProductDaoInter extends DataInter<Product> {

	/**
	 * 更新商品库存
	 * 
	 * @param id
	 *            商品id
	 * @param stock
	 *            新的库存
	 * @return true:更新成功
	 */
	boolean updateStock(int id, int stock);

}