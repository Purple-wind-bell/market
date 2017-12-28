package com.jsyunsi.market.Configure;

import java.io.File;

/**
 * 参数配置
 * 
 * @author Administrator
 *
 */
public final class Constant {
	/** mysql数据库连接 */
	static String mysqlUrl = "jdbc:mysql://localhost:3306/market";
	/** MySQL用户 */
	static String mysqlUser = "root";
	/** MySQL用户密码 */
	static String mysqlPasswd = "123456";
	/** 客户存储文件 */
	static String custUrl = "F:\\customerData.txt";
	/** 商品存储文件 */
	static String prodUrl = "F:\\productData.txt";

	private Constant() {
	}

	/**
	 * 获得客户文件位置
	 * 
	 * @return custUrl
	 */
	public static String getCustUrl() {
		return custUrl;
	}

	/**
	 * 获得商品文件位置
	 * 
	 * @return prodUrl
	 */
	public static String getProdUrl() {
		return prodUrl;
	}

	/**
	 * 获得数据库url
	 * 
	 * @return string类型的url
	 */
	public static String getMysqlUrl() {
		return mysqlUrl;
	}

	/**
	 * 获得MySQL用户名
	 * 
	 * @return 用户名
	 */
	public static String getMysqlUser() {
		return mysqlUser;
	}

	/**
	 * 获得MySQL用户密码
	 * 
	 * @return 密码
	 */
	public static String getMysqlPasswd() {
		return mysqlPasswd;
	}

}
