package com.jsyunsi.market.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.jsyunsi.market.DaoInter.ProductDaoInter;
import com.jsyunsi.market.utils.DBUtil;
import com.jsyunsi.market.vo.Product;

public class ProductMysqlDao implements ProductDaoInter {
	private Connection connection;

	@Override
	public ArrayList<Product> getList() {
		// TODO Auto-generated method stub
		ArrayList<Product> list = new ArrayList<Product>();
		Product product;
		String sql = "SELECT * FROM product";
		connection = DBUtil.getconnection();
		ResultSet resultSet = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int num = resultSet.getInt(1);
				String name = resultSet.getString(2);
				double price = resultSet.getDouble(3);
				int stock = resultSet.getInt(4);
				product = new Product(num, name, price, stock);
				list.add(product);
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
		String sql = "SELECT num FROM product";
		connection = DBUtil.getconnection();
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
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
	public boolean update(int id, Product t) {
		// TODO Auto-generated method stub
		int rows = 0;
		connection = DBUtil.getconnection();
		String sql = "UPDATE product SET num = ?, name =?, price = ?, stock =? WHERE num = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, t.getNum());
			ps.setString(2, t.getName());
			ps.setDouble(3, t.getPrice());
			ps.setInt(4, t.getStock());
			ps.setInt(5, id);
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
		ResultSet resultSet = null;
		int id = -1;
		String sql = "SELECT num FROM product WHERE num = ?";
		connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, num);
			resultSet = ps.executeQuery();
			id = resultSet.next() ? num : -1;
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
		String sql = "SELECT num FROM product WHERE name = ?";
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
	public boolean add(Product t) {
		// TODO Auto-generated method stub
		int rows = 0;
		connection = DBUtil.getconnection();
		String sql = "INSERT INTO product VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, t.getNum());
			ps.setString(2, t.getName());
			ps.setDouble(3, t.getPrice());
			ps.setInt(4, t.getStock());
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
		String sql = "DELETE FROM Product WHERE cardNum = ?";
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
	public Product getWithId(int id) {
		// TODO Auto-generated method stub
		Product product = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM Product WHERE num = ?";
		connection = DBUtil.getconnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			resultSet = ps.executeQuery();// 获取结果集
			while (resultSet.next()) {
				int num = resultSet.getInt(1);
				String name = resultSet.getString(2);
				double price = resultSet.getDouble(3);
				int stock = resultSet.getInt(4);
				product = new Product(num, name, price, stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return product;
	}

	@Override
	public boolean updateStock(int id, int stock) {
		// TODO Auto-generated method stub
		int rows = 0;
		connection = DBUtil.getconnection();
		String sql = "UPDATE product SET stock =? WHERE num = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setInt(2, id);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(connection);
		}
		return rows > 0;
	}

}
