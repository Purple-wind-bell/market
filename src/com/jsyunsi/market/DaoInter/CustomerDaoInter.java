package com.jsyunsi.market.DaoInter;

import com.jsyunsi.market.vo.Customer;

/**
 * customer操作接口
 * 
 * @author 紫风铃
 * @since 1.1
 */
public interface CustomerDaoInter {

	/**
	 * 获得当前用户数量
	 * 
	 * @return 用户数量
	 */
	int getAmount();

	/**
	 * 根据卡号获取用户的索引index
	 * 
	 * @param cardNum
	 *            卡号
	 * @return index
	 */
	int getIndex(int cardNum);

	/**
	 * 获得用户的索引index
	 * 
	 * @param name
	 *            用户姓名
	 * @return 索引
	 */
	int getIndex(String name);

	/**
	 * 获得用户对象
	 * 
	 * @param index
	 *            用户索引
	 * @return customer对象
	 */
	Customer getCustomerWithIndex(int index);

	/**
	 * 根据用户索引判断用户是否存在
	 * 
	 * @param index
	 *            用户索引
	 * @return true:用户存在
	 */
	boolean isExists(int index);

	/**
	 * 添加用户
	 * 
	 * @param customer
	 *            用户
	 * @return true:添加成功
	 */
	boolean add(Customer customer);

	/**
	 * 更新用户信息
	 * 
	 * @param cardNum
	 *            卡号
	 * @param name
	 *            姓名
	 * @param phone
	 *            手机号
	 * @return true:更新成功
	 */
	boolean update(int cardNum, String name, String phone);

	/**
	 * 根据索引删除用户
	 * 
	 * @param index
	 *            索引
	 * @return true:删除成功
	 */
	boolean delWithIndex(int index);

}