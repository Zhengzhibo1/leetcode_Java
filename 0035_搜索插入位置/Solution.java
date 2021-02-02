public class Solution {

// ====================算法实现=======================
	// 方法 二分查找
	// 时间复杂度O(log N)，其中n为数组的长度
	// 空间复杂度O(1)
	public int searchInsert(int[] nums, int target) {

		// 边界条件判断
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;
		int result = nums.length;

		while (left <= right) {

			int middle = (left + right) >> 1;
			if (nums[middle] == target) {
				return middle;
			}

			if (nums[middle] > target) {
				right = middle - 1;
				result = middle;
			}

			if (nums[middle] < target) {
				left = left + 1;
			}
		}

		return result;
	}

// ====================测试代码=======================
	public void test() {
		int nums[] = { 1, 3, 5, 6 };
		int target = 5;
		int result = searchInsert(nums, target);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
