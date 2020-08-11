public class Solution {

// ====================算法实现=================
	// 1 二分查找
	// 时间复杂度O(logN)，其中N为数组元素个数
	// 空间复杂度O(1)
	// 该方法首先利用min函数查找数组中最小元素
	// 然后将旋转数组分成两部分，判断应该在哪部分
	// 运用二分查找
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int indexMin = min(nums);
		if (target == nums[indexMin]) {
			return indexMin;
		} else if (target > nums[nums.length - 1]) {
			return searchCore(nums, target, 0, indexMin - 1);
		} else if (target <= nums[nums.length - 1]) {
			return searchCore(nums, target, indexMin, nums.length - 1);
		}

		return -1;
	}

	public int min(int[] nums) {
		int index1 = 0;
		int index2 = nums.length - 1;
		int indexMid = index1;

		while (nums[index1] > nums[index2]) {
			if (index2 - index1 == 1) {
				indexMid = index2;
				break;
			}
			indexMid = (index1 + index2) >> 1;
			if (nums[indexMid] >= nums[index1]) {
				index1 = indexMid;
			} else if (nums[indexMid] <= nums[index2]) {
				index2 = indexMid;
			}
		}

		return indexMid;
	}

	public int searchCore(int[] nums, int target, int start, int end) {
		int middle = 0;
		while (start <= end) {
			middle = (start + end) >> 1;
			if (nums[middle] == target) {
				return middle;
			} else if (nums[middle] > target) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}

		return -1;
	}

	// 2 简化二分查找
	// 时间复杂度O(logN)
	// 空间复杂度O(1)
	public int search2(int[] nums, int target) {

		// 边界条件判断
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			if (target == nums[0]) {
				return 0;
			} else {
				return -1;
			}
		}

		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (target == nums[mid]) {
				return mid;
			}
			if (nums[0] <= nums[mid]) {
				if (nums[0] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[nums.length - 1]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}

// ====================测试代码=================
	public void test1() {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		int result = search(nums, target);
		System.out.println(result);
	}

	public void test2() {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 3;
		int result = search(nums, target);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();

	}

}
