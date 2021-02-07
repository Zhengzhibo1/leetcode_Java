import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

// ===================算法实现========================
	// 方法 回溯集合法，利用3个集合分别保存，不能防止的列，斜线进行判断
	// 时间复杂度O(n!)
	// 空间复杂度O(n)
	public List<List<String>> solveNQueens(int n) {

		List<List<String>> resultList = new ArrayList<List<String>>();
		int queens[] = new int[n];
		Arrays.fill(queens, -1);
		Set<Integer> columns = new HashSet<Integer>();
		Set<Integer> diagonals1 = new HashSet<Integer>();
		Set<Integer> diagonals2 = new HashSet<Integer>();
		backtrack(resultList, queens, n, 0, columns, diagonals1, diagonals2);

		return resultList;
	}

	private void backtrack(List<List<String>> resultList, int[] queens, int n, int row, Set<Integer> columns,
			Set<Integer> diagonals1, Set<Integer> diagonals2) {

		if (row == n) {
			List<String> ans = generateAns(queens, n);
			resultList.add(ans);
		} else {
			for (int i = 0; i < n; i++) {
				if (columns.contains(i)) {
					continue;
				}
				int diagonal1 = row - i;
				if (diagonals1.contains(diagonal1)) {
					continue;
				}

				int diagonal2 = row + i;
				if (diagonals2.contains(diagonal2)) {
					continue;
				}

				queens[row] = i;
				columns.add(i);
				diagonals1.add(diagonal1);
				diagonals2.add(diagonal2);
				backtrack(resultList, queens, n, row + 1, columns, diagonals1, diagonals2);
				queens[row] = -1;
				columns.remove(i);
				diagonals1.remove(diagonal1);
				diagonals2.remove(diagonal2);
			}
		}
	}

	private List<String> generateAns(int[] queens, int n) {

		List<String> ans = new ArrayList<String>();

		for (int i = 0; i < n; ++i) {
			char row[] = new char[n];
			Arrays.fill(row, '.');
			row[queens[i]] = 'Q';
			ans.add(new String(row));

		}

		return ans;
	}

// ===================测试代码========================
	public void test() {
		int n = 4;
		List<List<String>> resultList = solveNQueens(n);
		for (List<String> temp : resultList) {
			for (String s : temp) {
				System.out.print(s + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
