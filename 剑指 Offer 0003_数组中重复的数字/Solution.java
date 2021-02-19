public class Solution {

// ===================算法实现===================
	// 方法 原地置换数字，寻找每个数字本该存在的位置，如果本该存在的位置的数字与当前数字一致，即为重复数字
	// 时间复杂度O(n)，n为数组的长度
	// 空间复杂度O(1)
	public int findRepeatNumber(int[] nums) {

		for (int i = 0; i < nums.length; ++i) {
			while (nums[i] != i) {

				int temp = nums[i];
				// 如果目标下标存在该数字，说明当前数字重复
				if (nums[temp] == temp) {
					return temp;
				}
				nums[i] = nums[temp];
				nums[temp] = temp;

			}
		}
		return -1;
	}

// ===================测试代码===================
	public void test() {
		int[] nums = { 2, 3, 1, 0, 2, 5, 3 };
		int result = findRepeatNumber(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
