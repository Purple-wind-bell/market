package com.jsyunsi.market.Dao;

import java.util.ArrayList;

import com.jsyunsi.market.DaoInter.ProductDaoInter;
import com.jsyunsi.market.vo.Product;

public class ProductMysqlDao implements ProductDaoInter<Integer> {

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
	public boolean add(Product t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delWithId(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getWithId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Integer id, Product t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStock(Integer id, int stock) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePrice(Integer id, int price) {
		// TODO Auto-generated method stub
		return false;
	}



}
