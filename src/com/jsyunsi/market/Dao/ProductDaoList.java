package com.jsyunsi.market.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import com.jsyunsi.market.DaoInter.ProductDaoInter;
import com.jsyunsi.market.vo.Customer;
import com.jsyunsi.market.vo.Product;

public class ProductDaoList implements ProductDaoInter {
	static ArrayList<Product> productlist = new ArrayList<>();
	/** 文件存储 */
	static File productFile = new File("F:\\productData.txt");
	static ObjectInputStream ois = null;

	static {
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
	}

	{
		this.add(new Product(1, "羽毛球拍", 250, 100));
		this.add(new Product(2, "羽毛球", 130, 100));
		this.add(new Product(3, "羽毛球鞋", 600, 100));
		writeList();
	}

	public ArrayList<Product> getList() {
		return productlist;
	}

	@Override
	public Product getWithIndex(int index) {
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
		return productlist.size();
	}

	@Override
	public int getIndex(int num) {
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
	public int getIndex(String name) {
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
			return productlist.add(product);
		}
	}

	@Override
	public boolean update(int num, Product product) {
		// TODO Auto-generated method stub
		int index = this.getIndex(num);
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
			Product data = productlist.get(index);
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
			Product data = productlist.get(index);
			data.setPrice(price);
			return true;
		} else {
			return false;
		}
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
	public static boolean readList() {
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
}
