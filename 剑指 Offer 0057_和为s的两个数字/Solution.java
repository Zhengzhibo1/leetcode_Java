public class Solution {

// ===================算法实现=====================
	// 方法 双指针法
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int[] twoSum(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;
		int curSum = 0;
		while (left < right) {
			curSum = nums[left] + nums[right];
			if (curSum == target) {
				return new int[] { nums[left], nums[right] };
			} else if (curSum > target) {
				right--;
			} else {
				left++;
			}
		}

		return null;
	}

// ===================测试代码=====================
	public void test() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = twoSum(nums, target);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
