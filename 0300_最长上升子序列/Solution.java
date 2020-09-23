public class Solution {

// ====================算法实现===================
	// 1 动态规划
	// 维护一个数组，存放当前坐标为结尾时的最长上升子序列
	// 时间复杂度O(n^2)
	// 空间复杂度O(n)
	public int lengthOfLIS(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int res = 1;
		int dp[] = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; ++i) {
			int maxval = 0;
			for (int j = 0; j < i; ++j) {
				if (nums[i] > nums[j]) {
					maxval = Math.max(maxval, dp[j]);
				}
			}
			dp[i] = maxval + 1;
			res = Math.max(res, dp[i]);
		}

		return res;
	}

// ====================测试代码===================
	public void test() {
		int nums[] = { 0 };
		int result = lengthOfLIS(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
