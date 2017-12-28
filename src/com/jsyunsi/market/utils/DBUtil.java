package com.jsyunsi.market.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接及释放的工具类
 * 
 * @author Administrator
 *
 */
public class DBUtil {
	static String url = "jdbc:mysql://localhost:3306/user";
	static String user = "root";
	static String pass = "123456";

	private DBUtil() {
	}

	public static Connection getconnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void releaseConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("释放失败");
		}
	}

}
