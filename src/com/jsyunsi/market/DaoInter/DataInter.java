package com.jsyunsi.market.DaoInter;

import java.util.ArrayList;

public interface DataInter<T, E> {

	/**
	 * 获取获得所有T对象的集合
	 * 
	 * @return T对象的集合
	 */
	ArrayList<T> getList();

	/**
	 * 获得List元素数量
	 * 
	 * @return 数量
	 */
	int getAmount();

	/**
	 * 获取ID
	 * 
	 * @param num
	 *            编号
	 * @return ID
	 */
	E getId(int num);

	/**
	 * 获取ID
	 * 
	 * @param name
	 *            名称
	 * @return ID
	 */
	E getId(String name);

	/**
	 * 判断是否存在
	 * 
	 * @param id
	 *            ID
	 * @return true:存在
	 */
	boolean isExists(E id);

	/**
	 * 添加数据
	 * 
	 * @param t
	 *            数据对象
	 * @return true:添加成功
	 */
	boolean add(T t);

	/**
	 * 根据ID删除数据
	 * 
	 * @param id
	 *            ID
	 * @return true:删除成功
	 */
	boolean delWithId(E id);

	/**
	 * 根据ID获取信息
	 * 
	 * @param id
	 *            ID
	 * @return T对象
	 */
	T getWithId(E id);

	/**
	 * 修改数据信息
	 * 
	 * @param t
	 *            新的数据对象
	 * @return true:修改成功
	 */
	boolean update(E id, T t);

}