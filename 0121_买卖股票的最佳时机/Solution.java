public class Solution {

// ====================算法实现==================
	// 1 一次遍历，类似滑动数组
	// 往后移动记录前面遍历过的数中的最小值
	// 时间复杂度O(n)，n为数组长度，仅需遍历一次数组
	// 空间复杂度O(1)
	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}

		int min = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; ++i) {
			if (prices[i] > min) {
				maxProfit = Math.max(maxProfit, prices[i] - min);
			}
			// 更新最小值
			min = Math.min(min, prices[i]);
		}

		return maxProfit;
	}

// ====================测试代码==================
	public void test() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int result = maxProfit(prices);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
