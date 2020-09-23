import java.util.HashMap;
import java.util.Map;

public class Solution {

// ===================算法实现======================
	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		Map<Integer, Integer> rows[] = new HashMap[9];
		Map<Integer, Integer> cols[] = new HashMap[9];
		Map<Integer, Integer> boxs[] = new HashMap[9];

		for (int i = 0; i < 9; ++i) {
			rows[i] = new HashMap<Integer, Integer>();
			cols[i] = new HashMap<Integer, Integer>();
			boxs[i] = new HashMap<Integer, Integer>();
		}

		for (int row = 0; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				char temp = board[row][col];
				if (temp == '.') {
					continue;
				}
				int num = (int) temp;
				int box_index = (row / 3) * 3 + col / 3;

				rows[row].put(num, rows[row].getOrDefault(num, 0) + 1);
				cols[col].put(num, cols[col].getOrDefault(num, 0) + 1);
				boxs[box_index].put(num, boxs[box_index].getOrDefault(num, 0) + 1);

				if (rows[row].get(num) > 1 || cols[col].get(num) > 1 || boxs[box_index].get(num) > 1) {
					return false;
				}
			}
		}

		return true;
	}

// ===================测试代码======================
	public void test() {
		char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		boolean result = isValidSudoku(board);
		System.out.println(result);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}
