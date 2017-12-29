package com.jsyunsi.market.Dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

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
		String sql = "SELECT * FROM customer";
		connection = DBUtil.getconnection();
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rSet = statement.executeQuery(sql);
			rSet.last();
			amount = rSet.getRow();
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
	public int getId(int num) {
		// TODO Auto-generated method stub
		int rows = -1;
		String sql = "SELECT * FROM customer num = ?";
		connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, num);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return rows > 0 ? num : -1;
	}

	@Override
	public int getId(String name) {
		// TODO Auto-generated method stub
		int id = -1;
		ResultSet rSet = null;
		String sql = "SELECT num FROM customer name = ?";
		connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			rSet = ps.executeQuery();// 获取结果集
			Class<Customer> class1 = Customer.class;// 通过反射获取id所属列的字段名
			Field[] field = class1.getFields();
			String cardNumColumn = field[0].getName();
			id = rSet.getInt(cardNumColumn);// 查询id
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
		String sql = "INSERT customer (?, ?, ?)";
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
		String sql = "DELETE * FROM customer WHERE cardNum = ?";
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
		ResultSet rSet = null;
		String sql = "SELECT cardNum FROM customer cardNum = ?";
		connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rSet = ps.executeQuery();// 获取结果集
			int cardNum = rSet.getInt(1);
			String name = rSet.getString(2);
			String phone = rSet.getString(3);
			customer = new Customer(cardNum, name, phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return customer;
	}

}
