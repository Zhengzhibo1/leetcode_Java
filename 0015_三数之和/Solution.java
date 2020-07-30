import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

// ====================算法实现====================
	// 1 排序 + 双指针
	// 时间复杂度O(N)，嵌套for循环
	// 时间复杂度O(logN)，排序函数需要logN的辅助空间
	// 因为改变了原数组，若不能改变原数组，则需要O(N)的空间储存原数组副本
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> results = new ArrayList<List<Integer>>();
		// 边界判断
		if (nums == null || nums.length <= 2) {
			return results;
		}

		// 排序
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; ++i) {
			if (nums[i] > 0) {
				break;
			}
			// 去重
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			// 固定第一个数字
			int target = -nums[i];
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (nums[left] + nums[right] == target) {
					results.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
					left++;
					right--;
					// 去重
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				} else if (nums[left] + nums[right] < target) {
					left++;
				} else {
					right--;
				}
			}
		}

		return results;
	}

// ====================测试代码====================
	public void test() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> results = threeSum(nums);
		for (List<Integer> result : results) {
			for (int i : result) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
