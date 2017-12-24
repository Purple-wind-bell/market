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
import com.jsyunsi.market.vo.CustomerData;

@SuppressWarnings("unchecked")
public class CustomerDaoList implements CustomerDaoInter {
	private static ArrayList<CustomerData> customerlist = new ArrayList<CustomerData>();
	static File customerFile = new File("F:\\customerData.txt");
	static ObjectInputStream ois = null;
	private int amount = 0;// 用户数量

	static {
		try {
			if (!customerFile.exists()) {
				customerFile.createNewFile();
			}
			ois = new ObjectInputStream(new FileInputStream(customerFile));
			// readList();
			customerlist = (ArrayList<CustomerData>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("空");
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
		Iterator<CustomerData> iterator = customerlist.iterator();
		while (iterator.hasNext()) {
			CustomerData temp = (CustomerData) iterator.next();
			if (temp.getCardNum() == cardNum) {
				return customerlist.indexOf(temp);
			}
		}
		return -1;
	}

	@Override
	public int getIndex(String name) {
		// TODO Auto-generated method stub
		Iterator<CustomerData> iterator = customerlist.iterator();
		while (iterator.hasNext()) {
			CustomerData temp = (CustomerData) iterator.next();
			if (temp.getName() == name) {
				return customerlist.indexOf(temp);
			}
		}
		return -1;
	}

	@Override
	public CustomerData getCustomerWithIndex(int index) {
		// TODO Auto-generated method stub
		try {
			return customerlist.get(index);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean Exists(int index) {
		// TODO Auto-generated method stub
		if (index >= 0 && index < customerlist.size()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean add(CustomerData customer) {
		// TODO Auto-generated method stub
		int index = getIndex(customer.getCardNum());
		if (!this.Exists(index) && (customerlist.add(customer))) {
			writeList();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(int cardNum, String name, String phone) {
		// TODO Auto-generated method stub
		CustomerData customer = new CustomerData(cardNum, name, phone);
		if (this.Exists(cardNum)) {
			try {
				customerlist.set(this.getIndex(cardNum), customer);
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
		if (this.Exists(index)) {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static boolean readList() {
		// TODO Auto-generated method stub
		try {
			customerlist = (ArrayList<CustomerData>) ois.readObject();
			return true;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
