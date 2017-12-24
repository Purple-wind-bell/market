package com.jsyunsi.market.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import com.jsyunsi.market.DaoInter.ProductDaoInter;
import com.jsyunsi.market.vo.ProductData;

public class ProductDaoList implements ProductDaoInter {
	ArrayList<ProductData> productlist = new ArrayList<ProductData>();
	private int amount = 0;// 用户数量
	private int index = -1;// 指定用户的索引

	{
		this.add(new ProductData(1, "羽毛球拍", 250, 100));
		this.add(new ProductData(2, "羽毛球", 130, 100));
		this.add(new ProductData(3, "羽毛球鞋", 600, 100));
	}

	public ArrayList<ProductData> getList() {
		return this.productlist;
	}

	@Override
	public ProductData getProductWithId(int num) {
		// TODO Auto-generated method stub
		if (this.Exists(num)) {
			return this.getProductWithId(num);
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
		Iterator<ProductData> iterator = productlist.iterator();
		while (iterator.hasNext()) {
			ProductData temp = (ProductData) iterator.next();
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
		Iterator<ProductData> iterator = productlist.iterator();
		while (iterator.hasNext()) {
			ProductData temp = (ProductData) iterator.next();
			if (temp.getName() == name) {
				this.index = productlist.indexOf(temp);
				return this.index;
			}
		}
		return -1;
	}

	@Override
	public boolean Exists(int index) {
		// TODO Auto-generated method stub
		if (index >= 0 && index < productlist.size()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean add(ProductData product) {
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
		ProductData product = new ProductData(num, name, price, stock);
		if (this.Exists(num)) {
			try {
				this.productlist.set(this.getIndex(num), product);
				return true;
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
			}
		}
		return false;
	}

	@Override
	public boolean delWithId(int num) {
		// TODO Auto-generated method stub
		if (this.Exists(num)) {
			try {
				productlist.remove(getIndex(num));
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
		if (Exists(index)) {
			ProductData data = this.productlist.get(index);
			data.setStock(stock);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updatePrice(int index, int price) {
		// TODO Auto-generated method stub
		if (Exists(index)) {
			ProductData data = this.productlist.get(index);
			data.setPrice(price);
			return true;
		} else {
			return false;
		}
	}
}
