import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

// ====================算法实现=====================
	// 方法：回溯
	// 时间复杂度O(2^N)，其中N为字符串长度
	// 空间复杂度O(N），递归深度
	// 存放临时结果集，去重
	private Set<String> set = new HashSet<String>();

	public List<String> removeInvalidParentheses(String s) {

		// 计算左右括号要删除的数量
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				left++;
			} else if (s.charAt(i) == ')') {
				right = left == 0 ? right + 1 : right;
				left = left > 0 ? left - 1 : left;
			}
		}

		recurse(s, 0, 0, 0, left, right, new StringBuilder());
		return new ArrayList<String>(set);

	}

	// 回溯
	/*
	 * s 表示输入字符串 index 表示字符串下标索引 leftCount 表示左括号数量 rightCount 表示右括号数量 leftRem
	 * 表示要删掉的左括号数量 rightRem 表示要删掉的右括号数量 expression 表示有效字符串
	 */
	private void recurse(String s, int index, int leftCount, int rightCount, int leftRem, int rightRem,
			StringBuilder expression) {

		if (index == s.length()) {
			if (leftRem == 0 && rightRem == 0) {
				// 如果要删除的括号数量为0，将有效表达式加入
				set.add(expression.toString());
			}
		} else {
			// 取出当前字符
			char curChar = s.charAt(index);
			int length = expression.length();
			// 如果当前字符为括号，且该类型括号待删除数量大于0，此括号可选择删除
			if ((curChar == '(' && leftRem > 0) || (curChar == ')' && (rightRem > 0))) {
				recurse(s, index + 1, leftCount, rightCount, leftRem - (curChar == '(' ? 1 : 0),
						rightRem - (curChar == ')' ? 1 : 0), expression);
			}

			// 如果不删除当前字符串
			expression.append(curChar);
			if (curChar != '(' && curChar != ')') {
				// 如果当前字符串为非括号字符，直接进入下一轮
				recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);
			} else if (curChar == '(') {
				// 如果当前字符等于左括号
				recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);
			} else if (rightCount < leftCount) {
				// 如果当前字符为右括号，且当前有多余左括号来匹配
				recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
			}

			// 回溯，删除最后一个字符
			expression.deleteCharAt(length);
		}
	}

// ====================测试代码=====================
	public void test() {
		String s = ")))((()))";
		List<String> list = removeInvalidParentheses(s);
		for (String result : list) {
			System.out.println(result);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
