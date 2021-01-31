public class Solution {

// ===================算法实现====================
	// 方法 二分查找
	// 时间复杂度O(log N)，如果数字都是一样，时间复杂度O(n)
	// 空间复杂度O(1)
	public int findMin(int[] nums) {

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {

			int middle = left + (right - left) / 2;
			if (nums[middle] < nums[right]) {
				right = middle;
			} else if (nums[middle] > nums[right]) {
				left = middle + 1;
			} else {
				right -= 1;
			}
		}

		return nums[right];
	}

// ===================测试代码====================
	public void test() {
		int nums[] = { 2, 2, 2, 0, 1 };
		int ans = findMin(nums);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
