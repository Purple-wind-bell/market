package com.jsyunsi.market.DaoInter;

import java.util.ArrayList;

import com.jsyunsi.market.vo.Product;

/**
 * product操作接口
 * 
 * @author 紫风铃
 * @since 1.1
 */
public interface ProductDaoInter {
	/**
	 * 获取product集合
	 * 
	 * @return product集合
	 */
	public ArrayList<Product> getList();

	/**
	 * 根据索引获取商品信息
	 * 
	 * @param index
	 *            商品索引
	 * @return customer对象
	 */
	public abstract Product getProductWithIndex(int index);

	/**
	 * 获得商品品种数量
	 * 
	 * @return 品种数量
	 */
	public abstract int getAmount();

	/**
	 * 获取商品索引
	 * 
	 * @param num
	 *            商品编号
	 * @return 商品索引
	 */
	public abstract int getIndex(int num);

	/**
	 * 获取商品索引
	 * 
	 * @param name
	 *            商品名称
	 * @return 商品索引
	 */
	public abstract int getIndex(String name);

	/**
	 * 判断商品是否存在
	 * 
	 * @param index
	 *            商品索引
	 * @return true:商品存在
	 */
	public abstract boolean isExists(int index);

	/**
	 * 添加商品
	 * 
	 * @param product
	 *            商品信息
	 * @return true:添加成功
	 */
	boolean add(Product product);

	/**
	 * 修改商品信息
	 * 
	 * @param num
	 *            商品编号
	 * @param name
	 *            商品名称
	 * @param price
	 *            商品价格
	 * @param stock
	 *            商品库存
	 * @return true:修改成功
	 */
	public abstract boolean update(int num, String name, double price, int stock);

	/**
	 * 根据索引删除商品
	 * 
	 * @param index
	 *            商品索引
	 * @return true:删除成功
	 */
	public abstract boolean delWithIndex(int index);

	/**
	 * 更新库存
	 * 
	 * @param index
	 *            商品索引
	 * @param stock
	 *            商品新的库存
	 * @return true:更新成功
	 */
	public abstract boolean updateStock(int index, int stock);

	/**
	 * 更新商品价格
	 * 
	 * @param index
	 *            商品索引
	 * @param price
	 *            商品价格
	 * @return true:更新成功
	 */
	public abstract boolean updatePrice(int index, int price);

}