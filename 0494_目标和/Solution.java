public class Solution {

// ===================算法实现====================
	// 1 暴力法
	// 时间复杂度O(2^N)，其中N为数组长度
	// 空间复杂度O(N)，递归深度
	int count = 0;

	public int findTargetSumWays(int[] nums, int S) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		findTargetSumWaysCore(nums, 0, 0, S);
		return count;
	}

	public void findTargetSumWaysCore(int[] nums, int i, int sum, int S) {
		if (i == nums.length) {
			if (sum == S) {
				count++;
			}
		} else {
			findTargetSumWaysCore(nums, i + 1, sum + nums[i], S);
			findTargetSumWaysCore(nums, i + 1, sum - nums[i], S);
		}
	}

	// 2 动态规划 + 空间优化
	// 时间复杂度O(N * sum)
	// 空间复杂度O(sum)
	public int findTargetSumWays2(int[] nums, int S) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] dp = new int[2001];
		dp[nums[0] + 1000] = 1;
		dp[-nums[0] + 1000] += 1;

		for (int i = 1; i < nums.length; i++) {
			int[] next = new int[2001];
			for (int sum = -1000; sum <= 1000; ++sum) {
				if (dp[sum + 1000] > 0) {
					next[sum + nums[i] + 1000] += dp[sum + 1000];
					next[sum - nums[i] + 1000] += dp[sum + 1000];
				}
			}
			dp = next;
		}
		return S > 1000 ? 0 : dp[S + 1000];
	}

// ==================测试代码=====================
	public void test() {
		int[] nums = { 1, 1, 1, 1, 1 };
		int S = 3;
		int result = findTargetSumWays2(nums, S);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
