public class Solution {

// ====================算法实现===================
	// 1 二分查找
	// 时间复杂度O(logN)，N为数组元素个数
	// 空间复杂度O(1)
	public int[] searchRange(int[] nums, int target) {

		int[] results = { -1, -1 };
		if (nums == null || nums.length == 0) {
			return results;
		}

		int first = -1;
		int last = -1;

		// 二分查找
		int start = 0;
		int end = nums.length - 1;
		int middle = 0;
		// 找目标数第一次出现的位置
		while (start <= end) {
			middle = (start + end) >> 1;
			if (target == nums[middle] && (middle == 0 || nums[middle - 1] != target)) {
				first = middle;
				break;
			} else if (target < nums[middle] || (target == nums[middle] && nums[middle - 1] == target)) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}

		start = 0;
		end = nums.length - 1;
		middle = 0;
		// 找目标数最后一次出现的位置
		while (start <= end) {
			middle = (start + end) >> 1;
			if (target == nums[middle] && (middle == nums.length - 1 || nums[middle + 1] != target)) {
				last = middle;
				break;
			} else if (target > nums[middle] || (target == nums[middle] && nums[middle + 1] == target)) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}

		results[0] = first;
		results[1] = last;
		return results;
	}

// =====================测试代码===================
	public void test1() {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		int[] results = searchRange(nums, target);
		for (int i : results) {
			System.out.print(i + "\t");
		}

		System.out.println();
	}

	public void test2() {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 6;
		int[] results = searchRange(nums, target);
		for (int i : results) {
			System.out.print(i + "\t");
		}

		System.out.println();
	}

	public void test3() {
		int[] nums = { 1 };
		int target = 1;
		int[] results = searchRange(nums, target);
		for (int i : results) {
			System.out.print(i + "\t");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();
		s.test3();

	}

}
