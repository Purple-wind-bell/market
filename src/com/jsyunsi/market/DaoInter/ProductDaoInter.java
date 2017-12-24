package com.jsyunsi.market.DaoInter;

import java.util.ArrayList;

import com.jsyunsi.market.vo.ProductData;

public interface ProductDaoInter {
	public ArrayList<ProductData> getList();

	public abstract ProductData getProductWithId(int num);

	public abstract int getAmount();

	public abstract int getIndex(int num);

	public abstract int getIndex(String name);

	public abstract boolean Exists(int index);

	boolean add(ProductData product);

	public abstract boolean update(int num, String name, double price, int stock);

	public abstract boolean delWithId(int num);

	public abstract boolean updateStock(int index, int stock);

	public abstract boolean updatePrice(int index, int price);

}