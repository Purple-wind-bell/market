package com.jsyunsi.market.Dao;

import java.lang.reflect.Field;
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
		String sql = "SELECT * FROM customer";
		connection = DBUtil.getconnection();
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rSet = statement.executeQuery(sql);
			rSet.last();
			amount = rSet.getRow();
			rSet.close();
			statement.close();
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
		int id = -1;
		String sql = "SELECT num FROM customer num = ?";
		connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, num);
			id = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return id > 0 ? num : -1;
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
		return id;
	}

	@Override
	public boolean isExists(int id) {
		// TODO Auto-generated method stub
		return id != -1;
	}

	@Override
	public boolean add(Customer t) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean delWithId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getWithId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
