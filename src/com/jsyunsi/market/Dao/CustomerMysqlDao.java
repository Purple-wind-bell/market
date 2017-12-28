package com.jsyunsi.market.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jsyunsi.market.DaoInter.CustomerDaoInter;
import com.jsyunsi.market.utils.DBUtil;
import com.jsyunsi.market.vo.Customer;

public class CustomerMysqlDao implements CustomerDaoInter<Integer> {
	ArrayList<Customer> list = new ArrayList<>();
	Connection connection;

	@Override
	public ArrayList<Customer> getList() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		int amount = 0;
		String sql = "SELECT COUNT(cardNum) FROM customer";
		connection = DBUtil.getconnection();
		try {
			Statement statement = connection.createStatement();
			amount = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return amount;
	}

	@Override
	public boolean update(Integer id, Customer t) {
		// TODO Auto-generated method stub
		int rows = 0;
		connection = DBUtil.getconnection();
		String sql = "UPDATE customer SET cardNum = ?, name = ?,phone = ? WHERE cardNum = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, t.getCardNum());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPhone());
			ps.setInt(4, id.intValue());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return rows > 0;
	}

	@Override
	public Integer getId(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getId(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Customer t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delWithId(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getWithId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
