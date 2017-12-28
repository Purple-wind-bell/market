package com.jsyunsi.market.serviceInter;

/**
 * 数据输入输出接口
 * 
 * @author Administrator
 *
 * @param <T>
 */
public interface IOServiceInter<T> {

	/**
	 * 获得输入数据
	 * 
	 * @return T对象
	 */
	T getInput();

	/**
	 * 输出数据
	 * 
	 * @param t
	 *            将要输出的数据
	 * @return true：输出成功
	 */
	boolean setOutput(T t);
}
