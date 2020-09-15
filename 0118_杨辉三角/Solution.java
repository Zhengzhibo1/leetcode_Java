import java.util.ArrayList;
import java.util.List;

public class Solution {

// ====================算法实现====================
	// 1 动态规划，根据一行的值算当前行的值
	// 时间复杂度O(numRows ^ 2)
	// 空间复杂度O(1)，除结果以外
	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return results;
		}

		List<Integer> result = new ArrayList<Integer>();
		result.add(1);
		results.add(result);

		for (int i = 2; i <= numRows; ++i) {
			result = new ArrayList<Integer>();
			for (int j = 0; j < i; ++j) {
				if (j == 0) {
					result.add(1);
				} else if (j == i - 1) {
					result.add(1);
				} else {
					result.add(results.get(i - 2).get(j - 1) + results.get(i - 2).get(j));
				}

			}
			results.add(result);
		}

		return results;
	}

// ====================测试代码====================
	public void test() {
		int numRows = 5;
		List<List<Integer>> results = generate(numRows);
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
