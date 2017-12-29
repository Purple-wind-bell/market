package com.jsyunsi.market.Dao;

import java.util.ArrayList;

import com.jsyunsi.market.DaoInter.ProductDaoInter;
import com.jsyunsi.market.vo.Product;

public class ProductMysqlDao implements ProductDaoInter {

	@Override
	public ArrayList<Product> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getId(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getId(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isExists(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Product t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delWithId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getWithId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(int id, Product t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStock(int id, int stock) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePrice(int id, int price) {
		// TODO Auto-generated method stub
		return false;
	}



}
