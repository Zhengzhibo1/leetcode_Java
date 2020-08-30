public class Solution {

// ====================算法实现=====================
	// 1 左右乘积列表
	// 时间复杂度O(n)，其中n为数组的长度
	// 空间复杂度O(N)
	public int[] productExceptSelf(int[] nums) {

		// 边界条件判断
		if (nums == null || nums.length <= 1) {
			return null;
		}
		int length = nums.length;
		int[] right = new int[length];
		int[] left = new int[length];

		int[] answer = new int[length];

		// 左乘积数组
		left[0] = 1;
		for (int i = 1; i < length; ++i) {
			left[i] = left[i - 1] * nums[i - 1];
		}

		// 右乘积数组
		right[length - 1] = 1;
		for (int i = length - 2; i >= 0; --i) {
			right[i] = right[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < length; ++i) {
			answer[i] = left[i] * right[i];
		}

		return answer;
	}

	// 2 空间复杂度为O(1)的方法
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int[] productExceptSelf2(int[] nums) {
		// 边界条件判断
		if (nums == null || nums.length <= 1) {
			return null;
		}

		int length = nums.length;
		int[] answer = new int[length];

		// answer当作左乘积数组
		answer[0] = 1;
		for (int i = 1; i < length; ++i) {
			answer[i] = answer[i - 1] * nums[i - 1];
		}

		// right 为右乘积
		int right = 1;
		for (int i = length - 1; i >= 0; --i) {
			answer[i] *= right;
			right *= nums[i];
		}

		return answer;
	}

// ====================测试代码=====================
	public void test() {
		int[] nums = { 1, 2, 3, 4 };
		int[] answer = productExceptSelf(nums);
		for (int i : answer) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
