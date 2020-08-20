public class Solution {

// ====================算法实现==================
	// 1 额外状态 -1 2
	// 时间复杂度O(m n)，m,n分别为数组的行数与列数
	// 空间复杂度O(1)
	public void gameOfLife(int[][] board) {

		// 边界条件判断
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int[] neighbors = { 0, 1, -1 };
		int rows = board.length;
		int cols = board[0].length;

		// 遍历每一个细胞
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {

				int liveNeighbors = 0;

				for (int i = 0; i < 3; ++i) {
					for (int j = 0; j < 3; ++j) {
						if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
							int r = row + neighbors[i];
							int c = col + neighbors[j];

							// 判断邻居细胞的存活数
							if ((r < rows && r >= 0) && (c < cols && c >= 0) && Math.abs(board[r][c]) == 1) {
								liveNeighbors++;
							}
						}
					}
				}

				// -1表示该细胞当前存活，下一个状态死亡
				// 规则 1 3
				if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
					board[row][col] = -1;
				}

				// 2表示当前细胞死亡，下一个状态存活
				// 规则 4
				if (board[row][col] == 0 && liveNeighbors == 3) {
					board[row][col] = 2;
				}
			}
		}

		// 再次遍历每个细胞，将-1 和 2 修改成对应的值
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				if (board[row][col] > 0) {
					board[row][col] = 1;
				} else {
					board[row][col] = 0;
				}
			}
		}

	}

// ====================测试代码==================
	public void test() {
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(board);

		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
