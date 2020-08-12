public class Solution {

// ====================算法实现==================
	// 1 双指针
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int removeElement(int[] nums, int val) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int lastNonValFoundAt = 0;
		for (int cur = 0; cur < nums.length; ++cur) {
			if (nums[cur] != val) {
				int temp = nums[lastNonValFoundAt];
				nums[lastNonValFoundAt] = nums[cur];
				nums[cur] = temp;
				lastNonValFoundAt++;
			}
		}
		return lastNonValFoundAt;
	}

// ====================测试代码==================
	public void test() {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		int result = removeElement(nums, val);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
