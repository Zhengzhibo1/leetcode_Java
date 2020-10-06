import java.util.Arrays;

public class Solution {

// ====================算法实现===================
	// 1 动态规划
	// 时间复杂度O(n * n^(1/2))，外循环n次，内循环n^(1/2)次
	// 空间复杂度O(n)
	public int numSquares(int n) {

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		int maxSquareIndex = (int) Math.sqrt(n) + 1;
		int[] squareNums = new int[maxSquareIndex];
		for (int i = 1; i < maxSquareIndex; ++i) {
			squareNums[i] = i * i;
		}

		for (int i = 1; i <= n; ++i) {
			for (int s = 1; s < maxSquareIndex; ++s) {
				if (i < squareNums[s]) {
					break;
				}

				dp[i] = Math.min(dp[i], dp[i - squareNums[s]] + 1);
			}
		}

		return dp[n];
	}

// ====================测试代码===================
	public void test() {
		int n = 12;

		int result = numSquares(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
