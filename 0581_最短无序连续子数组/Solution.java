import java.util.Arrays;

public class Solution {

// ===================算法实现=======================
	// 方法1 4次遍历，分别找出非排序子数组的最大值与最小值，确定左右边界
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int findUnsortedSubarray(int[] nums) {

		// 边界条件判断
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		// 从前往后，记录非排序子数组最小值
		boolean flag = false;
		for (int i = 1; i < nums.length; ++i) {

			if (nums[i] < nums[i - 1]) {
				flag = true;
			}

			if (flag) {
				min = Math.min(min, nums[i]);
			}
		}

		// 从后往前，记录非排序子数组最大值
		flag = false;
		for (int i = nums.length - 1; i > 0; --i) {
			if (nums[i] < nums[i - 1]) {
				flag = true;
			}

			if (flag) {
				max = Math.max(max, nums[i - 1]);
			}
		}

		// 找到排序子数组左边界
		int left, right;
		for (left = 0; left < nums.length; ++left) {
			if (nums[left] > min) {
				break;
			}
		}

		for (right = nums.length - 1; right >= 0; --right) {
			if (nums[right] < max) {
				break;
			}
		}

		return right - left < 0 ? 0 : right - left + 1;
	}

	// 方法2 排序
	// 时间复杂度O(N log N)，排序时间复杂度
	// 空间复杂度O(n)
	public int findUnsortedSubarray2(int[] nums) {

		// 边界条件判断
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] snums = nums.clone();
		Arrays.sort(snums);

		int start = snums.length - 1, end = 0;
		for (int i = 0; i < snums.length; ++i) {
			if (snums[i] != nums[i]) {
				start = Math.min(start, i);
				end = Math.max(end, i);
			}
		}

		return end - start <= 0 ? 0 : end - start + 1;
	}

// ===================测试代码=======================
	public void test() {
		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
		int result = findUnsortedSubarray(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
