public class Solution {

// ===================算法实现======================
	// 方法1 二分查找
	// 时间复杂度O(log N)
	// 空间复杂度O(1)
	public int findMin(int[] nums) {

		// 边界条件判断
		if (nums.length == 1) {
			return nums[0];
		}

		// 二分查找
		int left = 0;
		int right = nums.length - 1;
		// 如果没有旋转
		if (nums[right] > nums[0]) {
			return nums[0];
		}

		while (left <= right) {
			int middle = (left + right) >> 1;

			if (nums[middle] > nums[middle + 1]) {
				return nums[middle + 1];
			}

			if (nums[middle] < nums[middle - 1]) {
				return nums[middle];
			}

			if (nums[middle] > nums[0]) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}

		return -1;
	}

// ===================测试代码======================
	public void test() {
		int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
		int ans = findMin(nums);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
