import java.util.HashSet;
import java.util.Set;

public class Solution {

// ===================算法实现=====================
	// 方法 回溯集合法
	// 时间复杂度0(n!)
	// 空间复杂度O(n)
	public int totalNQueens(int n) {

		int result = 0;
		Set<Integer> columns = new HashSet<Integer>();
		Set<Integer> diagonals1 = new HashSet<Integer>();
		Set<Integer> diagonals2 = new HashSet<Integer>();
		result = backtrack(result, n, 0, columns, diagonals1, diagonals2);

		return result;
	}

	private int backtrack(int result, int n, int row, Set<Integer> columns, Set<Integer> diagonals1,
			Set<Integer> diagonals2) {

		if (row == n) {
			return result + 1;
		} else {
			for (int i = 0; i < n; ++i) {
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

				columns.add(i);
				diagonals1.add(diagonal1);
				diagonals2.add(diagonal2);
				result = backtrack(result, n, row + 1, columns, diagonals1, diagonals2);

				columns.remove(i);
				diagonals1.remove(diagonal1);
				diagonals2.remove(diagonal2);
			}
		}

		return result;
	}

// ===================测试代码======================
	public void test() {
		int n = 4;
		int result = totalNQueens(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
