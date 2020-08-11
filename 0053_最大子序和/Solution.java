public class Solution {

// ====================算法实现=================
	// 1 分析数组规律
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int maxSubArray(int[] nums) {

		// 边界条件判断
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		int curSum = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (curSum < 0) {
				curSum = nums[i];
			} else {
				curSum += nums[i];
			}

			if (curSum > max) {
				max = curSum;
			}
		}

		return max;
	}

// ====================测试代码=================
	public void test() {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = maxSubArray(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
