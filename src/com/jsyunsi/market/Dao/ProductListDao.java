package com.jsyunsi.market.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import com.jsyunsi.market.Configure.Constant;
import com.jsyunsi.market.DaoInter.ProductDaoInter;
import com.jsyunsi.market.vo.Product;

public class ProductListDao implements ProductDaoInter {
	static ArrayList<Product> productlist = new ArrayList<>();
	/** 文件存储 */
	static File productFile = new File(Constant.getProdUrl());
	static ObjectInputStream ois = null;

	{
		try {
			if (!productFile.exists()) {
				productFile.createNewFile();
				ois = new ObjectInputStream(new FileInputStream(productFile));
				readList();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(new Product(1, "羽毛球拍", 250, 100));
		this.add(new Product(2, "羽毛球", 130, 100));
		this.add(new Product(3, "羽毛球鞋", 600, 100));
		writeList();
	}

	public ArrayList<Product> getList() {
		return productlist;
	}

	@Override
	public Product getWithId(int id) {
		// TODO Auto-generated method stub
		if (this.isExists(id)) {
			return productlist.get(id);
		} else {
			return null;
		}
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return productlist.size();
	}

	@Override
	public int getId(int num) {
		// TODO Auto-generated method stub
		Iterator<Product> iterator = productlist.iterator();
		while (iterator.hasNext()) {
			Product temp = (Product) iterator.next();
			if (temp.getNum() == num) {
				return productlist.indexOf(temp);
			}
		}
		return -1;
	}

	@Override
	public int getId(String name) {
		// TODO Auto-generated method stub
		Iterator<Product> iterator = productlist.iterator();
		while (iterator.hasNext()) {
			Product temp = (Product) iterator.next();
			if (temp.getName() == name) {
				return productlist.indexOf(temp);
			}
		}
		return -1;
	}

	@Override
	public boolean isExists(int id) {
		// TODO Auto-generated method stub
		return (id >= 0 && id < productlist.size());
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		if (productlist.contains(product)) {
			return false;
		} else {
			return productlist.add(product);
		}
	}

	@Override
	public boolean update(int id, Product product) {
		// TODO Auto-generated method stub
		int index = this.getId(id);
		if (this.isExists(index)) {
			try {
				productlist.set(index, product);
				return true;
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
			}
		}
		return false;
	}

	@Override
	public boolean delWithId(int id) {
		// TODO Auto-generated method stub
		if (this.isExists(id)) {
			try {
				productlist.remove(id);
				return true;
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
			}
		}
		return false;
	}

	@SuppressWarnings("resource")
	public boolean writeList() {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = new FileOutputStream(productFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(productlist);
			oos.flush();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public boolean readList() {
		// TODO Auto-generated method stub
		try {
			Object list = ois.readObject();
			if (list != null && list.getClass() == productlist.getClass()) {
				productlist = (ArrayList<Product>) list;
			} else {
				productlist = null;
			}
			return true;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

	@Override
	public boolean updateStock(int id, int stock) {
		// TODO Auto-generated method stub
		productlist.get(id).setStock(stock);
		return true;
	}
}
