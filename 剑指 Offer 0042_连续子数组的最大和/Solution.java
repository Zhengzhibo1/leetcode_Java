public class Solution {

// ===================算法实现=====================
	// 方法 一次遍历，遍历到每个值时，比较当前最大值，如果当前和小于0，则从下一个数字重新开始
	// 时间复杂度O(n)，n为数组的长度
	// 空间复杂度O(1)
	public int maxSubArray(int[] nums) {

		// 边界条件判断
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int result = Integer.MIN_VALUE;
		int curSum = 0;
		for (int i = 0; i < nums.length; ++i) {
			curSum += nums[i];
			result = Math.max(result, curSum);

			if (curSum < 0) {
				curSum = 0;
			}

		}

		return result;
	}

// ===================测试代码=====================
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
