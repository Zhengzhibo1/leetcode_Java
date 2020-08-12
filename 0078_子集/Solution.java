import java.util.ArrayList;
import java.util.List;

public class Solution {

// ====================算法实现==================
	// 1 迭代，在已有结果中，添加当前数字
	// 时间复杂度O(N * 2^N)
	// 空间复杂度O(N * 2^N)
	// 对于给定的任意元素，它在子集中有两种情况，存在或者不存在。因此，N个数字共有 2^N个子集。
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		results.add(new ArrayList<Integer>());
		if (nums == null || nums.length == 0) {
			return results;
		}

		for (int num : nums) {
			List<List<Integer>> temps = new ArrayList<List<Integer>>();
			for (List<Integer> cur : results) {
				List<Integer> temp = new ArrayList<Integer>(cur);
				temp.add(num);
				temps.add(temp);
			}

			for (List<Integer> cur : temps) {
				results.add(cur);
			}
		}

		return results;
	}

	// 2 二进制掩码映射
	// 二进制掩码每一位，若为1，代表该位数字存在
	// 若为0，代表该位数字不存在
	// 时间复杂度O(N * 2^N)
	// 空间复杂度O(N * 2^N)
	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return results;
		}
		for (int i = 0; i < Math.pow(2, nums.length); ++i) {
			int index = nums.length - 1;
			List<Integer> temp = new ArrayList<Integer>();
			int j = i;
			while (index > -1) {
				if ((j & 1) == 1) {
					temp.add(nums[index]);
				}
				index--;
				j = j >> 1;
			}
			results.add(temp);
		}

		return results;
	}

// ====================测试代码==================
	public void test1() {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> results = subsets2(nums);
		for (List<Integer> result : results) {
			for (int i : result) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();

	}

}
