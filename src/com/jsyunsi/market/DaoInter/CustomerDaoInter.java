package com.jsyunsi.market.DaoInter;

import com.jsyunsi.market.vo.CustomerData;

public interface CustomerDaoInter {

	int getAmount();

	int getIndex(int cardNum);
	
	int getIndex(String name);

	CustomerData getCustomerWithIndex(int index);

	boolean Exists(int index);

	boolean add(CustomerData customer);

	boolean update(int cardNum, String name, String phone);

	boolean delWithIndex(int index);

}