import java.util.Arrays;

public class Solution {

// ===================算法实现======================
	// 方法1 排序法，该数在数组中间
	// 时间复杂度O(N logN)，n为数组的长度
	// 空间复杂度O(N)，排序需要
	public int majorityElement(int[] nums) {

		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	// 方法2 摩尔投票法
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int majorityElement2(int[] nums) {

		int result = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; ++i) {

			if (count == 0) {
				result = nums[i];
			}

			if (result == nums[i]) {
				count++;
			} else {
				count--;
			}
		}

		return result;
	}

// ===================测试代码======================
	public void test() {
		int[] nums = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		int result = majorityElement2(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
