import java.util.LinkedList;
import java.util.Queue;

public class Solution {

// =====================算法实现==================
	// 1 DFS
	// 时间复杂度O(M * N)，其中M，N为矩阵行列
	// 空间复杂度O(M * N)，取决于递归深度，最差情况，整个数组都是大陆
	public int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;

		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < cols; ++c) {
				if (grid[r][c] == '1') {
					count++;
					dfs(grid, r, c);
				}
			}
		}

		return count;
	}

	private void dfs(char[][] grid, int row, int col) {
		int rows = grid.length;
		int cols = grid[0].length;
		// 边界条件判断
		if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
			return;
		}

		grid[row][col] = '0';
		dfs(grid, row - 1, col);
		dfs(grid, row + 1, col);
		dfs(grid, row, col - 1);
		dfs(grid, row, col + 1);

	}

	// 2 BFS
	// 时间复杂度O(M * N)
	// 空间复杂度O(MIN(M, N))，在最坏情况下，整个网格均为陆地，队列的大小可以达到 MIN(M, N)。
	public int numIslands2(char[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;

		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				if (grid[row][col] == '1') {
					count++;
					grid[row][col] = '0';
					Queue<Integer> queue = new LinkedList<Integer>();
					queue.add(row * cols + col);
					while (!queue.isEmpty()) {
						int temp = queue.remove();
						int r = temp / cols;
						int c = temp % cols;
						if (r - 1 >= 0 && grid[r - 1][c] == '1') {
							grid[r - 1][c] = '0';
							queue.add((r - 1) * cols + c);
						}
						if (r + 1 < rows && grid[r + 1][c] == '1') {
							grid[r + 1][c] = '0';
							queue.add((r + 1) * cols + c);
						}
						if (c - 1 >= 0 && grid[r][c - 1] == '1') {
							grid[r][c - 1] = '0';
							queue.add(r * cols + c - 1);
						}
						if (c + 1 < cols && grid[r][c + 1] == '1') {
							grid[r][c + 1] = '0';
							queue.add(r * cols + c + 1);
						}
					}
				}
			}
		}

		return count;
	}

// =====================测试代码==================
	public void test() {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		int result = numIslands2(grid);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
