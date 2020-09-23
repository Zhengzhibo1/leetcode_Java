public class Solution {

// ====================算法实现======================
	// 1 深度优先搜索
	// 时间复杂度O(MN * 3^L)，其中M和N为字符数组的长宽，L为目标单词的长度
	// 因为正常情况下我们只会进入3个分支
	// 空间复杂度O(MN)，开辟了visited数组，同时递归的时间复杂度为O(Min(L, MN))
	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
			return false;
		}
		int rows = board.length;
		int cols = board[0].length;

		boolean visited[][] = new boolean[rows][cols];
		int strIndex = 0;
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				if (existCore(board, rows, cols, row, col, word, strIndex, visited)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean existCore(char[][] board, int rows, int cols, int row, int col, String word, int strIndex,
			boolean[][] visited) {
		if (strIndex == word.length()) {
			return true;
		}

		boolean isExist = false;
		if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == word.charAt(strIndex)
				&& !visited[row][col]) {
			strIndex++;
			visited[row][col] = true;

			isExist = existCore(board, rows, cols, row + 1, col, word, strIndex, visited)
					|| existCore(board, rows, cols, row - 1, col, word, strIndex, visited)
					|| existCore(board, rows, cols, row, col + 1, word, strIndex, visited)
					|| existCore(board, rows, cols, row, col - 1, word, strIndex, visited);

			if (!isExist) {
				visited[row][col] = false;
			}
		}

		return isExist;
	}

// ====================测试代码======================
	public void test() {
		char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		String word = "ABCCED";
		boolean result = exist(board, word);
		System.out.println(result);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
