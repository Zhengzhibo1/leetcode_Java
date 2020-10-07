import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

// ===================算法实现=====================
	// 1 哈希表
	// 时间复杂度O(n)，n为数组长度，遍历整个数组一遍
	// 空间复杂度O(n)，存储已经遍历过的元素
	public boolean containsDuplicate(int[] nums) {

		if (nums == null || nums.length == 0) {
			return false;
		}

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < nums.length; ++i) {
			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}

		return false;
	}

	// 2 排序
	// 时间复杂度O(N log N)，N为数组长度，排序所需时间复杂度
	// 空间复杂度O(1)，堆排序所需复杂度
	public boolean containsDuplicate2(int[] nums) {

		if (nums == null || nums.length == 0) {
			return false;
		}

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}

		return false;
	}

// ===================测试代码=====================
	public void test() {
		int[] nums = { 1, 2, 3, 1 };
		boolean result = containsDuplicate(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
