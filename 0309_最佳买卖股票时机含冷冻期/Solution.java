public class Solution {

// ====================算法实现===================
  // 总结：
	// 1、时间复杂度O(n)，其中n为数组长度
	// 1、空间复杂度O(1)
	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}

		// 每天存在3种状态
		int f0 = -prices[0]; // 第一天买入股票
		int f1 = 0; // 卖出股票，显然第一天不能卖，故为0
		int f2 = 0; // 当天不持有股票

		int newF0 = 0;
		int newF1 = 0;
		int newF2 = 0;
		// 股票买入为负收益即减去股票价格，股票卖出为正收益，即加上股票价格
		for (int i = 1; i < prices.length; ++i) {
			newF0 = Math.max(f0, f2 - prices[i]); // 当天持有股票，可能是前一天持有的，也可能是当天买的
			newF1 = f0 + prices[i]; // 当天卖出股票，前一天必须持有
			newF2 = Math.max(f1, f2); // 当天不持有股票，可能是前一天卖出，或者前一天不持有

			f0 = newF0;
			f1 = newF1;
			f2 = newF2;
		}

		return Math.max(f1, f2);
	}

// ====================测试代码===================
	public static void main(String[] args) {
		Solution s = new Solution();

		int[] prices1 = { 1, 2, 3, 0, 2 };
		int result1 = s.maxProfit(prices1);
		System.out.println(result1);
	}

}
