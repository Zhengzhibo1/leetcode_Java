import java.util.ArrayList;
import java.util.List;

public class Solution {

// ====================算法实现====================
	// 思路：将数组分成两部分，例如第一个数字固定，看作一部分
	// 后面数字看作一部分，第一个数字可以与后面数字进行交换
	// 时间复杂度O(n*n!)，递归次数为n!，例如第一个位置有n种可能，第二个位置n-1种可能
	// 对于每个排列数组，都需要O(n)来复制数组
	// 空间复杂度O(n)，递归调用栈深度为n。
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		permuteCore(nums, 0, result);
		return result;
	}

	public void permuteCore(int[] nums, int index, List<List<Integer>> result) {

		if (index == nums.length) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int i : nums) {
				temp.add(i);
			}
			result.add(temp);
		} else {
			for (int i = index; i < nums.length; ++i) {
				int t = nums[i];
				nums[i] = nums[index];
				nums[index] = t;

				permuteCore(nums, index + 1, result);

				t = nums[i];
				nums[i] = nums[index];
				nums[index] = t;
			}
		}

	}

// ====================测试代码====================
	public void test() {
		int[] nums = { 1, 2, 3, 4 };
		List<List<Integer>> result = permute(nums);
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
