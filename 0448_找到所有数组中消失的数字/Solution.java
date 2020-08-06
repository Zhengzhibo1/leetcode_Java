import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

// =====================算法实现================
	// 1 哈希表
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> results = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return results;
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; ++i) {
			set.add(nums[i]);
		}

		for (int i = 1; i <= nums.length; ++i) {
			if (!set.contains(i)) {
				results.add(i);
			}
		}

		return results;
	}

	// 2 修改原数组
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public List<Integer> findDisappearedNumbers2(int[] nums) {
		List<Integer> results = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return results;
		}

		for (int i = 0; i < nums.length; ++i) {
			int newIndex = Math.abs(nums[i]) - 1;
			nums[newIndex] = -Math.abs(nums[newIndex]);
		}

		for (int i = 1; i <= nums.length; ++i) {
			if (nums[i - 1] > 0) {
				results.add(i);
			}
		}

		return results;
	}

// =====================测试代码================
	public void test() {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> results = findDisappearedNumbers2(nums);
		for (int i : results) {
			System.out.print(i + "\t");
		}

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
