public class Solution {

// ====================算法实现=======================
	// 方法 动态规划
	// 时间复杂度O(S * N),其中S为总金额，N为不同面额硬币数量
	// 空间复杂度O(S)
	/*
	 * 动态规划，自顶向下思考，自底向上编程 F(S)代表S金额所需的最少硬币数 F(S) = min(F(s - coins[1]),...,F(s -
	 * coins[coins.length])) + 1 F(0) = 0,
	 */

	public int coinChange(int[] coins, int amount) {

		// 创建数组，存放中间结果
		int dp[] = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= amount; ++i) {
			for (int j = 0; j < coins.length; ++j) {
				if (i - coins[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]]);
				}
			}
			if (dp[i] != Integer.MAX_VALUE) {
				dp[i] += 1;
			}
		}

		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

// ====================测试代码=======================
	public void test() {
		int coins[] = { 1, 2, 5 };
		int amount = 11;
		int res = coinChange(coins, amount);
		System.out.println(res);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
