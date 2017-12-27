package com.jsyunsi.market.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import com.jsyunsi.market.DaoInter.ProductDaoInter;
import com.jsyunsi.market.vo.Product;

public class ProductDaoList implements ProductDaoInter {
	ArrayList<Product> productlist = new ArrayList<Product>();
	private int amount = 0;// 用户数量
	private int index = -1;// 指定用户的索引

	{
		this.add(new Product(1, "羽毛球拍", 250, 100));
		this.add(new Product(2, "羽毛球", 130, 100));
		this.add(new Product(3, "羽毛球鞋", 600, 100));
	}

	public ArrayList<Product> getList() {
		return this.productlist;
	}

	@Override
	public Product getProductWithIndex(int index) {
		// TODO Auto-generated method stub
		if (this.isExists(index)) {
			return productlist.get(index);
		} else {
			return null;
		}
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		this.amount = productlist.size();
		return this.amount;
	}

	@Override
	public int getIndex(int num) {
		// TODO Auto-generated method stub
		Iterator<Product> iterator = productlist.iterator();
		while (iterator.hasNext()) {
			Product temp = (Product) iterator.next();
			if (temp.getNum() == num) {
				this.index = productlist.indexOf(temp);
				return this.index;
			}
		}
		return -1;
	}

	@Override
	public int getIndex(String name) {
		// TODO Auto-generated method stub
		Iterator<Product> iterator = productlist.iterator();
		while (iterator.hasNext()) {
			Product temp = (Product) iterator.next();
			if (temp.getName() == name) {
				this.index = productlist.indexOf(temp);
				return this.index;
			}
		}
		return -1;
	}

	@Override
	public boolean isExists(int index) {
		// TODO Auto-generated method stub
		if (index >= 0 && index < productlist.size()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		if (productlist.contains(product)) {
			return false;
		} else {
			return this.productlist.add(product);
		}
	}

	@Override
	public boolean update(int num, String name, double price, int stock) {
		// TODO Auto-generated method stub
		Product product = new Product(num, name, price, stock);
		int index = this.getIndex(num);
		if (this.isExists(index)) {
			try {
				this.productlist.set(index, product);
				return true;
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
			}
		}
		return false;
	}

	@Override
	public boolean delWithIndex(int num) {
		// TODO Auto-generated method stub
		int index = this.getIndex(num);
		if (this.isExists(index)) {
			try {
				productlist.remove(index);
				return true;
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
			}
		}
		return false;
	}

	@Override
	public boolean updateStock(int index, int stock) {
		// TODO Auto-generated method stub
		if (isExists(index)) {
			Product data = this.productlist.get(index);
			data.setStock(stock);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updatePrice(int index, int price) {
		// TODO Auto-generated method stub
		if (isExists(index)) {
			Product data = this.productlist.get(index);
			data.setPrice(price);
			return true;
		} else {
			return false;
		}
	}
}
