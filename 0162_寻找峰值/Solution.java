public class Solution {

// ====================算法实现===================
	// 方法1 一次遍历
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int findPeakElement(int[] nums) {

		// 边界条件判断，如果为空，则返回-1
		if (nums == null || nums.length == 0) {
			return -1;
		}

		for (int i = 0; i < nums.length - 1; ++i) {
			// 因为nums[-1]是负无穷
			if (nums[i] > nums[i + 1]) {
				return i;
			}
		}
		return nums.length - 1;
	}

	// 方法2 二分查找递归实现
	// 时间复杂度O(log N)
	// 空间复杂度O(log N)，取决于递归深度
	public int findPeakElement2(int[] nums) {

		// 边界条件判断，如果为空，则返回-1
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int result = dfs(nums, 0, nums.length - 1);
		return result;
	}

	private int dfs(int[] nums, int left, int right) {
		if (left == right) {
			return left;
		}
		int mid = (left + right) >> 1;
		if (nums[mid] > nums[mid + 1]) {
			// mid处于下坡中，左侧有峰值
			return dfs(nums, left, mid);
		} else {
			// mid处于上坡中，右侧有峰值
			return dfs(nums, mid + 1, right);
		}
	}

	// 方法3 二分查找迭代实现
	// 时间复杂度O(log N)
	// 空间复杂度O(1)
	public int findPeakElement3(int[] nums) {

		// 边界条件判断，如果为空，则返回-1
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (nums[mid] > nums[mid + 1]) {
				// mid处于下坡中，左侧有峰值
				right = mid;
			} else {
				// mid处于上坡中，右侧有峰值
				left = mid + 1;
			}
		}

		return left;
	}

// ====================测试代码===================
	public void test() {
		int nums[] = { 1, 2, 1, 3, 5, 6, 4 };
		int peekIndex = findPeakElement3(nums);
		System.out.println("峰值的下标为：" + peekIndex);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
