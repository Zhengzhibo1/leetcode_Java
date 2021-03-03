public class Solution {

// ===================算法实现=====================
	// 方法 动态规划 当前最大利润 = Max（前一日最大利润， 当日价格 - 前几日最低价格），因为仅买卖一次
	// 时间复杂度O(n)，n为数组的长度
	// 空间复杂度O(1)
	public int maxProfit(int[] prices) {

		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int price : prices) {
			minPrice = Math.min(minPrice, price);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}

		return maxProfit;
	}

// ===================测试代码=====================
	public void test() {
		int[] prices = { 7, 6, 4, 3, 1 };
		int profit = maxProfit(prices);
		System.out.println(profit);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
