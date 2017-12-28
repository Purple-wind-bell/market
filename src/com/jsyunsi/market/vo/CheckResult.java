package com.jsyunsi.market.vo;

/**
 * 用户查询返回结果
 * 
 * @author Administrator
 *
 */
public class CheckResult {
	/** 查询返回码 */
	int status;
	/** 错误次数 */
	int errorCount;

	public CheckResult(int status, int errorCount) {
		super();
		this.status = status;
		this.errorCount = errorCount;
	}

	public int getStatus() {
		return status;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

}
