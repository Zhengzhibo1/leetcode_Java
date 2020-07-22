import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

// ====================算法实现==================
	// 1 递归 回溯
	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (candidates == null) {
			return results;
		}

		int length = candidates.length;
		Arrays.sort(candidates);

		combinationSumCore(candidates, length, target, 0, new ArrayList<Integer>(), results);
		return results;
	}

	public void combinationSumCore(int[] candidates, int length, int rest, int begin, List<Integer> result,
			List<List<Integer>> results) {

		if (rest == 0) {
			results.add(new ArrayList<Integer>(result));
			return;
		}

		for (int i = begin; i < length; ++i) {

			// 剪枝，若当前值大于剩余值，那么后面的值都将比这个大
			// 故此处跳出循环，注：数组提前排好序
			if (candidates[i] > rest) {
				break;
			}

			// 如果当前值与前一个值相同，则直接进入下一轮循环，去重
			if (i > begin && candidates[i] == candidates[i - 1]) {
				continue;
			}

			// 回溯
			result.add(candidates[i]);

			// begin为i + 1，起始位置往后移一位
			combinationSumCore(candidates, length, rest - candidates[i], i + 1, result, results);
			result.remove(result.size() - 1);
		}
	}

// ====================测试代码==================
	public void test() {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> results = combinationSum(candidates, target);
		for (List<Integer> res : results) {
			for (int i : res) {
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
