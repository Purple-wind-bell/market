package com.jsyunsi.market.Exception;

public class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1044524829587556625L;

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		System.out.println("输入格式错误！请重新输入");
	}

}
