public class Solution {

// ====================算法实现===================
	// 方法1 左遍历 + 右遍历，即第i天为分界点，0-i天内的最大利润，i-最后一天内的最大利润
	// 时间复杂度O(n)，其中n为数组长度，按顺序遍历数组
	// 空间复杂度O(n)
	public int maxProfit(int[] prices) {

		// 边界条件判断
		if (prices == null || prices.length == 0) {
			return 0;
		}

		// 从左往右遍历求取0-i天内的最大利润
		int leftProfit[] = new int[prices.length];
		int minPrice = Integer.MAX_VALUE; // 最小值
		int leftMaxProfit = 0; // 左区间最大利润
		for (int i = 0; i < prices.length; ++i) {
			minPrice = Math.min(minPrice, prices[i]);
			leftMaxProfit = Math.max(leftMaxProfit, prices[i] - minPrice);
			leftProfit[i] = leftMaxProfit;
		}

		// 从右往左遍历求取i-最后一天内的最大利润
		int rightProfit[] = new int[prices.length];
		int maxPrice = Integer.MIN_VALUE;
		int rightMaxProfit = 0; // 右区间最大利润
		for (int i = prices.length - 1; i >= 0; --i) {
			maxPrice = Math.max(maxPrice, prices[i]);
			rightMaxProfit = Math.max(rightMaxProfit, maxPrice - prices[i]);
			rightProfit[i] = rightMaxProfit;
		}

		int maxProfit = 0;
		for (int i = 0; i < prices.length; ++i) {
			maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
		}

		return maxProfit;
	}

	// 方法2 动态规划，参照0188_买卖股票的最佳时机 IV

// ====================测试代码===================
	public void test() {
		int prices[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int profit = maxProfit(prices);
		System.out.println("Max Profit： " + profit);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
