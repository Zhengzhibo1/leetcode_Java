import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

// ====================算法实现==================
	// 回溯法 每个数字可以存在结果中也可以不存在，且如果当前数字与上一个数字相同即跳过，避免重复答案
	// 时间复杂度O(n * 2^n)，一共有2^n个状态，每个状态需要O(n)的时间来构造结果集
	// 空间复杂度O(n)，其中n为数组长度，该空间用来存放中间结果
	public List<List<Integer>> subsetsWithDup(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		// 对数组进行排序，时间复杂度O(N * log N)，空间复杂度O(logN)
		Arrays.sort(nums);
		getResult(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}

	// 递归
	private void getResult(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result) {

		// 添加结果集，时间复杂度为O(n)
		result.add(new ArrayList<Integer>(tempList));
		for (int i = start; i < nums.length; ++i) {

			// 如果当前数字与上一个数字一样，则跳过
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}

			// 该结果存在该数字
			tempList.add(nums[i]);
			// 递归调用
			getResult(nums, i + 1, tempList, result);
			// 该结果不存在该数字
			tempList.remove(tempList.size() - 1);
		}
	}

// ====================测试代码==================
	public void test() {
		int nums[] = { 1, 2, 2 };
		List<List<Integer>> result = subsetsWithDup(nums);
		for (List<Integer> ans : result) {
			for (int i : ans) {
				System.out.print(i + "" + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
