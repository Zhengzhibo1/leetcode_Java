import java.util.ArrayList;
import java.util.List;

public class Solution {

// ====================算法实现=================
	// 1 暴力解法，n对括号，共2*n个字符，共2^(2*n)种排列组合
	// 时间复杂度O(2^(2*n)n),对于 2^(2n)个序列中的每一个，我们用于建立和验证该序列的复杂度为 O(n)。
	// 空间复杂度O(n),取决于递归深度，最多递归2n层。
	public List<String> generateParenthesis(int n) {

		List<String> result = new ArrayList<String>();
		generateAll(new char[2 * n], 0, result);
		return result;
	}

	public void generateAll(char[] current, int pos, List<String> result) {
		if (pos == current.length) {
			if (valid(current)) {
				result.add(new String(current));
			}
		} else {
			current[pos] = '(';
			generateAll(current, pos + 1, result);
			current[pos] = ')';
			generateAll(current, pos + 1, result);
		}
	}

	// 验证是否符合要求
	public boolean valid(char[] current) {
		int balance = 0;
		for (char c : current) {
			if (c == '(') {
				balance++;
			} else {
				balance--;
				if (balance < 0) {
					return false;
				}
			}
		}
		return balance == 0;
	}

	// 2 回溯法
	// 时间复杂度：O(4^n/n^(1/2))，每个答案需要 O(n)的时间复制到答案数组中。
	// 空间复杂度：O(n)，取决于递归的深度，最多递归2n层。

	public List<String> generateParenthesis2(int n) {
		List<String> result = new ArrayList<String>();
		backtrace(result, new StringBuilder(), 0, 0, n);
		return result;
	}

	public void backtrace(List<String> result, StringBuilder cur, int open, int close, int max) {
		if (cur.length() == 2 * max) {
			result.add(cur.toString());
			return;
		}

		if (open < max) {
			cur.append('(');
			backtrace(result, cur, open + 1, close, max);
			cur.deleteCharAt(cur.length() - 1);
		}
		if (close < open) {
			cur.append(')');
			backtrace(result, cur, open, close + 1, max);
			cur.deleteCharAt(cur.length() - 1);
		}
	}

// ====================测试代码=================
	public void test() {
		int n = 3;
		List<String> result = generateParenthesis2(n);
		for (String s : result) {
			System.out.print(s + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
