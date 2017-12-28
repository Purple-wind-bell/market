package com.jsyunsi.market.Configure;

import java.io.File;

/**
 * 参数配置
 * 
 * @author Administrator
 *
 */
public final class Config {
	/** 客户存储文件 */
	static File customerFile = new File("F:\\customerData.txt");
	/** 商品存储文件 */
	static File productFile = new File("F:\\productData.txt");

	private Config() {
	}

	/**
	 * 获得客户文件位置
	 * 
	 * @return customerFile
	 */
	public static File getCustomerFile() {
		return customerFile;
	}

	/**
	 * 获得商品文件位置
	 * 
	 * @return productFile
	 */
	public static File getProductFile() {
		return productFile;
	}
}
