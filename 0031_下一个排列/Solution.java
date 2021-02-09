public class Solution {

// ===================算法实现====================
	// 方法 二次遍历，寻找左边的较小数与右边的较大数进行交换
	// 时间复杂度O(n)
  // 空间复杂度O(1)
	public void nextPermutation(int[] nums) {

		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		// 如果存在下一个更大的排列
		if (i >= 0) {
			int j = nums.length - 1;
			while (j > i && nums[i] >= nums[j]) {
				j--;
			}

			// 交换数字
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}

		// 翻转剩余数组
		int left = i + 1;
		int right = nums.length - 1;
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;

			left++;
			right--;
		}
	}

// ===================测试代码====================
	public void test() {
		int nums[] = { 1, 3, 2 };
		nextPermutation(nums);
		for (int i : nums) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
