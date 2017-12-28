package com.jsyunsi.market.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jsyunsi.market.Configure.Constant;

/**
 * 数据库连接及释放的工具类
 * 
 * @author Administrator
 *
 */
public class DBUtil {
	private DBUtil() {
	}

	public static Connection getconnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Constant.getMysqlUrl(), Constant.getMysqlUser(),
					Constant.getMysqlPasswd());
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
