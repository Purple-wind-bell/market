package com.jsyunsi.market.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsyunsi.market.ServiceInter.CheckServiceInter;
import com.jsyunsi.market.utils.DBUtil;

/**
 * 用户登录检测实现
 * 
 * @author Administrator
 *
 */
public class LoginCheckService implements CheckServiceInter {
	// private Admin admin = new Admin();

	@Override
	public int check(String user, String passwd) {
		int status = 0;
		// --密码对错判断
		// 方法1
		// if (user.equals(admin.getUser())) {
		// if (passwd.equals(admin.getPasswd())) {
		// status = 3;// 密码正确
		// } else {
		// status = 2;// 密码错误
		// }
		// } else {
		// status = 1;
		// }

		// 方法2-数据库查询
		ResultSet resultSet = null;
		String sql = "SELECT * FROM Admin WHERE user = ?";
		Connection connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user);
			resultSet = ps.executeQuery();
			if (resultSet == null) {
				status = 1;// 用户不存在
			} else if (resultSet.getString(2) == passwd) {
				status = 3;// 密码正确
			} else {
				status = 2;// 密码错误
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = 0;
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return status;
	}
}