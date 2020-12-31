import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

// ====================算法实现====================
	// 方法 回溯
	// 时间复杂度O(n*n!)，递归次数为n!，例如第一个位置有n种可能，第二个位置n-1种可能
	// 对于每个排列数组，都需要O(n)来复制数组
	// 空间复杂度O(n)，递归调用栈深度为n。
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		// 对数组进行排序
		Arrays.sort(nums);

		List<Integer> temp = new ArrayList<Integer>();
		// 该数组用于判断数字是否被使用
		boolean vis[] = new boolean[nums.length];
		backtrace(vis, nums, result, 0, temp);
		return result;
	}

	public void backtrace(boolean vis[], int[] nums, List<List<Integer>> result, int index, List<Integer> temp) {

		// 如果数字填充完毕
		if (index == nums.length) {
			result.add(new ArrayList<Integer>(temp));
		} else {
			for (int i = 0; i < nums.length; ++i) {
				if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
					continue;
				}

				temp.add(nums[i]);
				vis[i] = true;
				backtrace(vis, nums, result, index + 1, temp);
				vis[i] = false;
				temp.remove(index);
			}
		}
	}

// ====================测试代码====================
	public void test() {
		int[] nums = { 3, 3, 0, 3 };
		List<List<Integer>> result = permuteUnique(nums);
		for (List<Integer> r : result) {
			for (int i : r) {
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
