package com.jsyunsi.market.service;

import com.jsyunsi.market.ServiceInter.GoodLuckServiceInter;

/**
 * 抽奖服务类
 * 
 * @author Administrator
 *
 */
public final class GoodLuckService implements GoodLuckServiceInter {

	/**
	 * 抽奖方法
	 * 
	 * @param askForLottery
	 *            抽奖的请求参数，true表示进行抽奖
	 * @return 以小数形式表示的折扣值
	 */
	public double lottery(boolean askForLottery) {
		/** 折扣属性 */
		double dis = 1;
		if (askForLottery) {
			double luckValue = Math.random();// 生成幸运值
			if (luckValue < 0.7) {
				dis = 1;
			} else {
				dis = luckValue;
			}
		}
		return dis;
	}
}
