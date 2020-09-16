public class Solution {

// ====================算法实现====================
	// 1 数学求和公式，然后减去数组的每一个元素，剩余的值即为缺失数字
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int missingNumber(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int res = 0;
		int n = nums.length;
		int sum = n * (n + 1) / 2;
		for (int i = 0; i < n; ++i) {
			res += nums[i];
		}

		res = sum - res;
		return res;
	}

	// 2 异或
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int missingNumber2(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int missing = nums.length;
		for (int i = 0; i < nums.length; ++i) {
			missing ^= i ^ nums[i];
		}

		return missing;
	}

// ====================测试代码====================
	public void test() {
		int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int result = missingNumber(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
