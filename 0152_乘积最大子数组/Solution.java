public class Solution {

// ====================算法实现=====================
	// 1 动态规划 + 空间优化
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int maxProduct(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int maxF = nums[0];
		int minF = nums[0];
		int ans = nums[0];

		for (int i = 1; i < nums.length; ++i) {
			int max = maxF;
			int min = minF;
			maxF = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
			minF = Math.min(min * nums[i], Math.min(max * nums[i], nums[i]));
			ans = Math.max(maxF, ans);
		}

		return ans;
	}

// ====================测试代码=====================
	public void test() {
		int[] nums = { 2, 3, -2, 4 };
		int result = maxProduct(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
