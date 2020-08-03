import java.util.HashSet;
import java.util.Set;

public class Solution {

// ====================算法实现===================
	// 1 哈希表
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int longestConsecutive(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		// set去重
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			set.add(num);
		}

		int longest = 0;
		for (int num : set) {
			if (!set.contains(num - 1)) {
				int curLong = 1;
				int curNum = num;
				while (set.contains(curNum + 1)) {
					curLong++;
					curNum++;
				}

				longest = Math.max(longest, curLong);
			}
		}

		return longest;
	}

// ====================测试代码===================
	public void test() {
		int[] nums = { 100, 4, 200, 1, 3, 4, 2 };
		int result = longestConsecutive(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
