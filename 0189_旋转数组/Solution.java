public class Solution {

// ====================算法实现=========================
	// 1 使用额外数组
	// 时间复杂度O(n)
	// 空间复杂度O(k)
	public void rotate(int[] nums, int k) {

		if (k == 0 || k == nums.length) {
			return;
		}

		if (k > nums.length) {
			k = k - nums.length;
		}

		int length = nums.length;
		int index = length - k;
		int[] kNums = new int[k];
		for (int i = index; i < length; ++i) {
			kNums[i - index] = nums[i];
		}

		for (int i = index - 1; i >= 0; --i) {
			nums[i + k] = nums[i];
		}

		for (int i = 0; i < k; ++i) {
			nums[i] = kNums[i];
		}
	}

	// 2 使用反转
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public void rotate2(int[] nums, int k) {

		if (k == 0 || k == nums.length) {
			return;
		}

		if (k > nums.length) {
			k = k - nums.length;
		}

		// 反转所有数字
		int index1 = 0;
		int index2 = nums.length - 1;
		while (index1 < index2) {
			int temp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = temp;

			index1++;
			index2--;
		}

		// 反转前k个数字
		index1 = 0;
		index2 = k - 1;
		while (index1 < index2) {
			int temp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = temp;

			index1++;
			index2--;
		}

		// 反转剩余数字
		index1 = k;
		index2 = nums.length - 1;
		while (index1 < index2) {
			int temp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = temp;

			index1++;
			index2--;
		}
	}

// ====================测试代码=========================
	public void test() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate2(nums, k);

		for (int i : nums) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
