import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

// ===================算法实现======================
	// 方法 数组排序+双指针
	// 时间复杂度O(n^3)
	// 空间复杂度O(logN)，为数组排序所需空间复杂度
	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		int n = nums.length;

		// 边界条件判断
		if (nums == null || nums.length < 4) {
			return resultList;
		}

		// 对数组进行排序
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; ++i) {

			// 剪枝
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
				continue;
			}

			if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
				continue;
			}

			for (int j = i + 1; j < nums.length - 2; ++j) {

				// 剪枝
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}

				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
					continue;
				}

				if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
					continue;
				}

				int tempSum = target - nums[i] - nums[j];
				int left = j + 1;
				int right = n - 1;

				while (left < right) {

					if (nums[left] + nums[right] == tempSum) {
						List<Integer> tempList = new ArrayList<Integer>();
						tempList.add(nums[i]);
						tempList.add(nums[j]);
						tempList.add(nums[left]);
						tempList.add(nums[right]);
						resultList.add(tempList);

						left++;
						right--;
						// 去重
						while (left < right && nums[left] == nums[left - 1]) {
							left++;
						}

						while (left < right && nums[right] == nums[right + 1]) {
							right--;
						}

					} else if (nums[left] + nums[right] > tempSum) {
						right--;
					} else if (nums[left] + nums[right] < tempSum) {
						left++;
					}

				}
			}
		}

		return resultList;
	}

// ===================测试代码======================
	public void test() {
		int nums[] = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		List<List<Integer>> resultList = fourSum(nums, target);
		for (List<Integer> tempList : resultList) {
			for (int i : tempList) {
				System.out.println(i + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
