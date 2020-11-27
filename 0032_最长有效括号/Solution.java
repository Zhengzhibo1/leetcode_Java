import java.util.Deque;
import java.util.LinkedList;

public class Solution {

// ===================算法实现==================
	// 方法1 动态规划
	// 时间复杂度O(n)，其中n为字符串的长度
	// 空间复杂度O(n)，需要n大小的数组存放动态规划结果
	/*
	 * 思路：dp[i]表示以当前字符串结束的有效字符串长度， 1、当前字符串为'('时，dp[i] = 0, 2、当前字符串为')'时，需要考虑前一个字符串，
	 * 前一个字符串为'('时，形如“.....()”的样子，dp[i] = dp[i - 2] + 2; 3、当前字符串为')'时，需要考虑前一个字符串，
	 * 前一个字符串为')'时，形如“.....))”的样子，如果 s[i - dp[i - 1] - 1] ='(' dp[i] = dp[i - 1] + 2
	 * + dp[i - dp[i - 1] - 2]，即有长度为前一个字符的有效长度+2+再前面字符的有效长度
	 */
	public int longestValidParentheses(String s) {

		// 边界条件判断，如果字符串为空，则返回0
		if (s == null || s.length() == 0) {
			return 0;
		}
		// 最长有效字符串长度
		int maxLength = 0;
		// 字符串长度
		int length = s.length();
		// 创建动态规划数组
		int dp[] = new int[length];
		for (int i = 1; i < length; ++i) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i - 1 > 0 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}

		return maxLength;
	}

	// 方法2 左右各遍历一次
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	/*
	 * left 代表左括号数量，right代表右括号数量 向右遍历时，如果遇到左括号，left++；如果遇到右括号，right++；如果left ==
	 * right，即为有效字符长度，如果right > left，则置0，重新开始计数 向左遍历是，同理，即left > right时，置0。
	 */
	public int longestValidParentheses2(String s) {
		// 边界条件判断，如果字符串为空，则返回0
		if (s == null || s.length() == 0) {
			return 0;
		}
		// 最长有效字符串长度
		int maxLength = 0;
		// 字符串长度
		int length = s.length();
		int left = 0, right = 0;

		// 向右遍历
		for (int i = 0; i < length; ++i) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxLength = Math.max(maxLength, left + right);
			} else if (right > left) {
				left = 0;
				right = 0;
			}
		}

		// 先置0
		left = 0;
		right = 0;

		// 向左遍历
		for (int i = length - 1; i >= 0; --i) {
			if (s.charAt(i) == ')') {
				right++;
			} else {
				left++;
			}

			if (left == right) {
				maxLength = Math.max(maxLength, left);
			} else if (right < left) {
				left = 0;
				right = 0;
			}
		}

		return maxLength;
	}

	// 方法3 栈
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	/*
	 * 栈中存放下标，首先存入-1，代表最后一个没有被匹配的右括号下标 如果是左括号，直接将下标压入，
	 * 如果是右括号，从栈顶弹出元素，如果栈为空，则代表匹配括号失败， 即弹出的是一个右括号，因为栈最下面的是最后一个没有被匹配的右括号下标， 当前下标压入栈中，
	 * 代表最后一个没有被匹配的右括号下标
	 */
	public int longestValidParentheses3(String s) {

		// 边界条件判断，如果字符串为空，则返回0
		if (s == null || s.length() == 0) {
			return 0;
		}
		// 最长有效字符串长度
		int maxLength = 0;
		// 字符串长度
		int length = s.length();

		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(-1);
		for (int i = 0; i < length; ++i) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop(); // 弹出栈顶
				if (stack.isEmpty()) {
					// 如果栈为空，代表括号匹配失败，当前下标入栈
					stack.push(i);
				} else {
					// 如果括号匹配成功
					maxLength = Math.max(maxLength, i - stack.peek());
				}
			}
		}

		return maxLength;
	}

// ===================测试代码==================
	public void test() {
		String s = ")()())";
		int result = longestValidParentheses3(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}
