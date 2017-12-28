package com.jsyunsi.market.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import com.jsyunsi.market.DaoInter.CustomerDaoInter;
import com.jsyunsi.market.vo.Customer;

public class CustomerDaoList implements CustomerDaoInter {
	/** customer对象集合 */
	private static ArrayList<Customer> customerlist = new ArrayList<>();
	/** 文件存储 */
	static File customerFile = new File("F:\\customerData.txt");
	static ObjectInputStream ois = null;
	/** 用户数量 */
	private int amount = 0;

	static {
		try {
			if (!customerFile.exists()) {
				customerFile.createNewFile();
				ois = new ObjectInputStream(new FileInputStream(customerFile));
				readList();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		this.amount = customerlist.size();
		return this.amount;
	}

	@Override
	public int getIndex(int cardNum) {
		// TODO Auto-generated method stub
		Iterator<Customer> iterator = customerlist.iterator();
		while (iterator.hasNext()) {
			Customer temp = iterator.next();
			if (temp.getCardNum() == cardNum) {
				return customerlist.indexOf(temp);
			}
		}
		return -1;
	}

	@Override
	public int getIndex(String name) {
		// TODO Auto-generated method stub
		Iterator<Customer> iterator = customerlist.iterator();
		while (iterator.hasNext()) {
			Customer temp = iterator.next();
			if (temp.getName() == name) {
				return customerlist.indexOf(temp);
			}
		}
		return -1;
	}

	@Override
	public Customer getWithIndex(int index) {
		// TODO Auto-generated method stub
		try {
			return customerlist.get(index);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean isExists(int index) {
		// TODO Auto-generated method stub
		if (index >= 0 && index < customerlist.size()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean add(Customer customer) {
		// TODO Auto-generated method stub
		int index = getIndex(customer.getCardNum());
		if (!this.isExists(index) && (customerlist.add(customer))) {
			writeList();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(int cardNum, String name, String phone) {
		// TODO Auto-generated method stub
		Customer customer = new Customer(cardNum, name, phone);
		int index = this.getIndex(cardNum);
		if (this.isExists(index)) {
			try {
				customerlist.set(index, customer);
				writeList();
				return true;
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
			}
		}
		return false;
	}

	public boolean delWithIndex(int index) {
		// TODO Auto-generated method stub
		if (this.isExists(index)) {
			customerlist.remove(index);
			writeList();
			return true;
		} else {
			return false;
		}
	}

	public boolean writeList() {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("resource")
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(customerFile));
			oos.writeObject(customerlist);
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
			if (list != null && list.getClass() == customerlist.getClass()) {
				customerlist = (ArrayList<Customer>) list;
			} else {
				customerlist = null;
			}
			return true;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

}
