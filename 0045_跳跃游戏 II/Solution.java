public class Solution {

// ===================算法实现===================
	// 方法 贪心算法
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int jump(int[] nums) {

		// 边界条件判断
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		// 上一步跳跃后所能达到的最远距离
		int end = 0;
		// 用于存放每一步的最远距离
		int maxPosition = 0;
		int steps = 0;

		for (int i = 0; i < nums.length - 1; ++i) {
			maxPosition = Math.max(maxPosition, i + nums[i]);
			if (i == end) {
				end = maxPosition;
				steps++;
			}
		}

		return steps;
	}

// ===================测试代码===================
	public void test() {
		int[] nums = { 2, 3, 1, 1, 4 };
		int steps = jump(nums);
		System.out.println(steps);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
