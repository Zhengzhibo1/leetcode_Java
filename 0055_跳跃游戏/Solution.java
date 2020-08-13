public class Solution {

// ====================算法实现===================
	// 1 贪心
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	// 每移动一步，均判断该位置是否在最大可到达距离中
	// 并更新最大可到达距离
	public boolean canJump(int[] nums) {

		if (nums == null || nums.length == 0) {
			return false;
		}

		int most = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (i <= most) {
				most = Math.max(most, i + nums[i]);
				if (most >= nums.length - 1) {
					return true;
				}
			} else {
				break;
			}
		}
		return false;
	}

// ====================测试代码===================
	public void test() {
		int[] nums = { 2, 3, 1, 1, 4 };
		boolean result = canJump(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
