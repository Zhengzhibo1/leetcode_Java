public class Solution {

// ===================算法实现====================
	// 方法 一次遍历 + 设置 num1, num2 用于存放最小值与中间值
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public boolean increasingTriplet(int[] nums) {

		// 边界条件判断
		if (nums == null || nums.length < 3) {
			return false;
		}

		int num1 = Integer.MAX_VALUE;
		int num2 = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] <= num1) {
				num1 = nums[i];
				continue;
			} else if (nums[i] <= num2) {
				num2 = nums[i];
				continue;
			} else {
				return true;
			}
		}

		return false;
	}

// ===================测试代码====================
	public void test() {
		int[] nums = { 2, 1, 5, 0, 4, 6 };
		boolean result = increasingTriplet(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
