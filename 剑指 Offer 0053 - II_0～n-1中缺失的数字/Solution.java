public class Solution {

// ===================算法实现=====================
	// 方法 二分查找
	// 时间复杂度O(n log n)，n为数组的长度
	// 空间复杂度O(1)
	public int missingNumber(int[] nums) {

		// 二分查找
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int middle = left + (right - left) / 2;

			if (nums[middle] != middle) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}

		return right + 1;
	}

// ===================测试代码=====================
	public void test() {
		int[] nums = { 0, 1, 3 };
		int result = missingNumber(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
