import java.util.ArrayList;
import java.util.List;

public class Solution {

// ===================算法实现====================
	// 1 按行排序
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); ++i) {
			rows.add(new StringBuilder());
		}

		int curRow = 0;
		boolean goingDown = false;
		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1) {
				goingDown = !goingDown;
			}
			curRow += goingDown ? 1 : -1;
		}

		StringBuilder ret = new StringBuilder();
		for (StringBuilder row : rows) {
			ret.append(row);
		}

		return ret.toString();
	}

	// 2 按行访问
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public String convert2(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		StringBuilder ret = new StringBuilder();
		int n = s.length();
		int cycleLen = 2 * numRows - 2;

		for (int i = 0; i < numRows; ++i) {
			for (int j = 0; j + i < n; j += cycleLen) {
				ret.append(s.charAt(j + i));
				if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
					ret.append(s.charAt(j + cycleLen - i));
				}
			}
		}

		return ret.toString();
	}

// ===================测试代码====================
	public void test() {
		String s = "LEETCODEISHIRING";
		String result = convert(s, 3);
		System.out.println(result);
	}

	public void test2() {
		String s = "LEETCODEISHIRING";
		String result = convert2(s, 4);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
		s.test2();

	}

}
