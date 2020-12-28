import java.util.Arrays;

public class Solution {

// ===================算法实现=====================
	// 方法 动态规划 状态转移方程
	/*
	 * buy[i][j] 第i日价格，进行了j笔交易所产生的最大收益，且手头持有股票； 可以从buy[i - 1][j]转移得到，也可以从sell[i -
	 * 1][j] - price[i]转移得到， 即两者间的最大值。 sell[i][j] 第i日价格，进行了j笔交易所产生的最大收益，且手头没有股票
	 * 可以从buy[i - 1][j - 1] + price[i]转移得到，也可以从sell[i - 1][j]转移得到， 即两者间的最大值。 边界条件：
	 * 1、交易次数最多为天数/2 2、buy[0][0] = -prices[0] 3、buy[0][1...k]，不合法，等于一个很小的值
	 * 4、sell[0][0] = 0 5、sell[0][1...k]，不合法，等于一个很小的值 6、sell[i][j]可以从buy[i - 1][j -
	 * 1] + price[i]状态转移得到，如果j = 0，即不转移， 依然令sell[i][j] = 0
	 */
	// 时间复杂度O(n*MIN(n/2,k))
	// 空间复杂度O(n*MIN(n/2,k))
	public int maxProfit(int k, int[] prices) {

		// 边界条件判断
		if (prices == null || prices.length == 0 || k == 0) {
			return 0;
		}

		int n = prices.length;
		// 交易次数
		k = Math.min(k, n / 2);
		// 创建临时数组，存放中间结果
		int[][] buy = new int[n][k + 1];
		int[][] sell = new int[n][k + 1];

		// 初始值
		buy[0][0] = -prices[0];
		sell[0][0] = 0;
		for (int i = 1; i <= k; ++i) {
			// 取最小值的一半，是为了防止溢出
			buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
		}

		// 状态转移
		for (int i = 1; i < n; ++i) {
			buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
			for (int j = 1; j <= k; ++j) {
				buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
				sell[i][j] = Math.max(buy[i - 1][j - 1] + prices[i], sell[i - 1][j]);
			}
		}

		// 最后结果为手中不持有股票的最大值
		return Arrays.stream(sell[n - 1]).max().getAsInt();
	}

// ===================测试代码=====================
	public void test() {
		int prices[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int k = 2;
		int result = maxProfit(k, prices);
		System.out.println("Max Profix: " + result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
