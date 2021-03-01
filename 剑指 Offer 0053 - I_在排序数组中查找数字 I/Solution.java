public class Solution {

// ===================算法实现========================
	// 方法 二分查找
	// 时间复杂度O(log N)
	// 空间复杂度O(1)
	public int search(int[] nums, int target) {

		return helper(nums, target) - helper(nums, target - 1);
	}

	// 找到目标数的后一个数
	private int helper(int[] nums, int target) {

		int left = 0, right = nums.length - 1;
		while (left <= right) {

			int middle = left + (right - left) / 2;
			if (nums[middle] <= target) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}

		return left;
	}

// ===================测试代码========================
	public void test() {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		int count = search(nums, target);
		System.out.println(count);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
