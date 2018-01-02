package com.jsyunsi.market.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.jsyunsi.market.DaoInter.CustomerDaoInter;
import com.jsyunsi.market.utils.DBUtil;
import com.jsyunsi.market.vo.Customer;

public class CustomerMysqlDao implements CustomerDaoInter {
	Connection connection;

	@Override
	public ArrayList<Customer> getList() {
		// TODO Auto-generated method stub
		ArrayList<Customer> list = new ArrayList<Customer>();
		Customer customer;
		String sql = "SELECT * FROM customer";
		connection = DBUtil.getconnection();
		ResultSet resultSet = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int cardNum = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String phone = resultSet.getString(3);
				customer = new Customer(cardNum, name, phone);
				list.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return list;
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		int amount = 0;
		String sql = "SELECT cardNum FROM customer";
		connection = DBUtil.getconnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			resultSet.last();
			amount = resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return amount;
	}

	@Override
	public boolean update(int id, Customer t) {
		// TODO Auto-generated method stub
		int rows = 0;
		connection = DBUtil.getconnection();
		String sql = "UPDATE customer SET cardNum = ?, name = ?,phone = ? WHERE cardNum = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, t.getCardNum());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPhone());
			ps.setInt(4, id);
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
	public int getId(int cardNum) {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		int id = -1;
		String sql = "SELECT cardNum FROM customer WHERE cardNum = ?";
		connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, cardNum);
			resultSet = ps.executeQuery();
			id = resultSet.next() ? cardNum : -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return id;
	}

	@Override
	public int getId(String name) {
		// TODO Auto-generated method stub
		int id = -1;
		ResultSet resultSet = null;
		String sql = "SELECT cardNum FROM customer WHERE name = ?";
		connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			resultSet = ps.executeQuery();// 获取结果集
			while (resultSet.next()) {
				id = resultSet.getInt(1);// 查询id
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id > 0 ? id : -1;
	}

	@Override
	public boolean isExists(int id) {
		// TODO Auto-generated method stub
		return id != -1;
	}

	@Override
	public boolean add(Customer t) {
		// TODO Auto-generated method stub
		int rows = 0;
		connection = DBUtil.getconnection();
		String sql = "INSERT INTO customer VALUES(?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, t.getCardNum());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPhone());
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
	public boolean delWithId(int id) {
		// TODO Auto-generated method stub
		int rows = 0;
		connection = DBUtil.getconnection();
		String sql = "DELETE FROM customer WHERE cardNum = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
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
	public Customer getWithId(int id) {
		// TODO Auto-generated method stub
		Customer customer = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM customer WHERE cardNum = ?";
		connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			resultSet = ps.executeQuery();// 获取结果集
			while (resultSet.next()) {
				int cardNum = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String phone = resultSet.getString(3);
				customer = new Customer(cardNum, name, phone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return customer;
	}

}
