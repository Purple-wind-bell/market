package com.jsyunsi.market.DaoInter;

import java.util.ArrayList;

public interface DataInter<T> {

	/**
	 * 获取T集合
	 * 
	 * @return T集合
	 */
	ArrayList<T> getList();

	/**
	 * 获得List元素数量
	 * 
	 * @return 数量
	 */
	int getAmount();

	/**
	 * 获取索引
	 * 
	 * @param num
	 *            编号
	 * @return 索引
	 */
	int getIndex(int num);

	/**
	 * 获取索引
	 * 
	 * @param name
	 *            名称
	 * @return 索引
	 */
	int getIndex(String name);

	/**
	 * 判断是否存在
	 * 
	 * @param index
	 *            索引
	 * @return true:存在
	 */
	boolean isExists(int index);

	/**
	 * 添加数据
	 * 
	 * @param t
	 *            数据对象
	 * @return true:添加成功
	 */
	boolean add(T t);

	/**
	 * 根据索引删除数据
	 * 
	 * @param index
	 *            索引
	 * @return true:删除成功
	 */
	boolean delWithIndex(int index);

	/**
	 * 根据索引获取信息
	 * 
	 * @param index
	 *            索引
	 * @return T对象
	 */
	T getWithIndex(int index);

	/**
	 * 修改数据信息
	 * 
	 * @param t
	 *            新的数据对象
	 * @return true:修改成功
	 */
	boolean update(int num, T t);

	boolean writeList();

	boolean readList();

}