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
import com.jsyunsi.market.DaoInter.CustomerDaoInter;
import com.jsyunsi.market.vo.Customer;

public class CustomerListDao implements CustomerDaoInter<Integer> {
	/** customer对象集合 */
	private static ArrayList<Customer> customerlist = new ArrayList<>();
	/** 文件存储 */
	static File customerFile = new File(Constant.getCustUrl());
	static ObjectInputStream ois = null;

	{
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
		return customerlist.size();
	}

	@Override
	public ArrayList<Customer> getList() {
		// TODO Auto-generated method stub
		return customerlist;
	}

	@Override
	public Integer getId(int cardNum) {
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
	public Integer getId(String name) {
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
	public Customer getWithId(Integer id) {
		// TODO Auto-generated method stub
		try {
			return customerlist.get(id);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean isExists(Integer id) {
		// TODO Auto-generated method stub
		if (id >= 0 && id < customerlist.size()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean add(Customer customer) {
		// TODO Auto-generated method stub
		int index = getId(customer.getCardNum());
		if (!this.isExists(index) && (customerlist.add(customer))) {
			writeList();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(Integer id, Customer customer) {
		// TODO Auto-generated method stub
		int index = this.getId(id.intValue());
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

	public boolean delWithId(Integer id) {
		// TODO Auto-generated method stub
		int index = id;
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
	public boolean readList() {
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
