public class Solution {

// ====================算法实现=================
	// 1 动态规划 滚动数组存放结果
	// 时间复杂度O(n)，其中n为数组长度，整体遍历一次
	// 空间复杂度O(1)
	public int rob(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int first = nums[0];
		int second = Math.max(nums[0], nums[1]);

		int temp = 0;
		for (int i = 2; i < nums.length; ++i) {
			temp = second;
			second = Math.max(nums[i] + first, second);
			first = temp;
		}

		return second;
	}

// ====================测试代码=================
	public void test() {
		int[] nums = { 2, 7, 9, 3, 1 };
		int result = rob(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
