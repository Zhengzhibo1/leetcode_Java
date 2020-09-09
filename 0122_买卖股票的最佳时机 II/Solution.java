public class Solution {

// ====================算法实现==================
	// 1 暴力法
	// 时间复杂度O(N^N)
	// 空间复杂度O(N)，递归深度为N
	public int maxProfit(int[] prices) {

		// 边界条件判断
		if (prices == null || prices.length < 1) {
			return 0;
		}

		return calculate(prices, 0);
	}

	public int calculate(int prices[], int s) {
		if (s >= prices.length) {
			return 0;
		}

		int max = 0;
		for (int start = s; start < prices.length; ++start) {
			int maxprofit = 0;
			for (int i = start + 1; i < prices.length; ++i) {
				if (prices[start] < prices[i]) {
					int profit = calculate(prices, i + 1) + prices[i] - prices[start];
					if (profit > maxprofit) {
						maxprofit = profit;
					}
				}
			}
			max = Math.max(maxprofit, max);
		}
		return max;
	}

	// 2 一次遍历
	// 时间复杂度O(N)
	// 空间复杂度O(1)
	public int maxProfit2(int[] prices) {
		// 边界条件判断
		if (prices == null || prices.length < 1) {
			return 0;
		}

		int profit = 0;
		for (int i = 0; i < prices.length; ++i) {
			if (i + 1 < prices.length && prices[i] < prices[i + 1]) {
				profit += prices[i + 1] - prices[i];
			}
		}

		return profit;
	}

	// 3 峰谷法
	// 时间复杂度O(N)
	// 空间复杂度O(1)
	public int maxProfit3(int[] prices) {
		// 边界条件判断
		if (prices == null || prices.length < 1) {
			return 0;
		}
		
		int profit = 0;
		int i = 0;
		int valley = prices[0];
		int peak = prices[0];
		
		while(i < prices.length - 1) {
			while(i < prices.length - 1 && prices[i] >= prices[i + 1]) {
				i++;
			}
			valley = prices[i];
			while(i < prices.length - 1 && prices[i] <= prices[i + 1]) {
				++i;
			}
			peak = prices[i];
			profit += peak - valley;
		}
		
		return profit;
	}
// ===================测试代码===================
	public void test() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int result = maxProfit3(prices);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
