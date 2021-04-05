public class Solution {

// ===================算法实现=====================
	// 方法 深度优先搜索
	// 时间复杂度O(3^k*m*n)，k为字符串长度，m，n分别为数组的行列数，3^k表示每一步都有三个方向可以选择，除了来时的方向
	// 空间复杂度O(k)，递归深度
	public boolean exist(char[][] board, String word) {

		char[] words = word.toCharArray();
		int rows = board.length;
		int cols = board[0].length;
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {

				boolean result = dfs(board, words, i, j, 0);
				if (result == true)
					return true;
			}
		}

		return false;
	}

	private boolean dfs(char[][] board, char[] words, int row, int col, int k) {
		if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != words[k]) {
			return false;
		}

		if (k == words.length - 1) {
			return true;
		}
		// 标记为访问过
		board[row][col] = '\0';

		boolean result = dfs(board, words, row + 1, col, k + 1) || dfs(board, words, row - 1, col, k + 1)
				|| dfs(board, words, row, col + 1, k + 1) || dfs(board, words, row, col - 1, k + 1);
		// 还原标记
		board[row][col] = words[k];

		return result;
	}

// ===================测试代码=====================
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
