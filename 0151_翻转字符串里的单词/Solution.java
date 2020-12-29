import java.util.Deque;
import java.util.LinkedList;

public class Solution {

// ===================算法实现===================
	// 方法1 去多余空格，再翻转
	// 时间复杂度O(n)，n为字符串长度
	// 空间复杂度O(n)，存放临时结果
	public String reverseWords(String s) {

		// 边界条件判断
		if (s == null || s.length() == 0) {
			return "";
		}

		// 去掉多余空格
		StringBuilder sb = trimSpaces(s);
		// 翻转整串
		reverse(sb, 0, sb.length() - 1);
		// 翻转每个单词
		reverseEachWord(sb);

		return sb.toString();
	}

	// 去掉多余空格
	private StringBuilder trimSpaces(String s) {
		int left = 0, right = s.length() - 1;
		// 去掉字符串开头空格
		while (left <= right && s.charAt(left) == ' ') {
			++left;
		}

		// 去掉字符串末尾空格
		while (right >= left && s.charAt(right) == ' ') {
			--right;
		}

		// 去掉字符串多余的空格
		StringBuilder sb = new StringBuilder();
		while (left <= right) {
			char c = s.charAt(left);

			if (c != ' ') {
				sb.append(c);
			} else if (s.charAt(left - 1) != ' ') {
				sb.append(c);
			}

			left++;
		}

		return sb;
	}

	// 翻转整串
	private void reverse(StringBuilder sb, int left, int right) {
		while (left < right) {
			char temp = sb.charAt(left);
			sb.setCharAt(left++, sb.charAt(right));
			sb.setCharAt(right--, temp);
		}
	}

	// 翻转每一个单词
	private void reverseEachWord(StringBuilder sb) {
		int n = sb.length();
		int start = 0, end = 0;

		while (start < n) {
			// 找到单词末尾
			while (end < n && sb.charAt(end) != ' ') {
				end++;
			}

			// 翻转该单词
			reverse(sb, start, end - 1);

			// 下一个单词
			start = end + 1;
			end = start;
		}
	}

	// 方法2 双端队列
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public String reverseWords2(String s) {

		// 边界条件判断
		if (s == null || s.length() == 0) {
			return "";
		}

		// 去掉首尾空格
		int left = 0, right = s.length() - 1;
		while (left <= right && s.charAt(left) == ' ') {
			left++;
		}

		while (right >= left && s.charAt(right) == ' ') {
			right--;
		}

		// 创建双端队列
		Deque<String> wordList = new LinkedList<String>();
		StringBuilder word = new StringBuilder();

		while (left <= right) {

			if (word.length() != 0 && s.charAt(left) == ' ') {
				// 往队列头部添加单词
				wordList.offerFirst(word.toString());
				word.setLength(0);
			}

			if (s.charAt(left) != ' ') {
				word.append(s.charAt(left));
			}

			left++;
		}

		// 将最后一个单词添加到队列中
		wordList.offerFirst(word.toString());

		return String.join(" ", wordList);
	}

// ===================测试代码===================
	public void test1() {
		String s = "  Bob    Loves  Alice   ";
		String result = reverseWords(s);
		System.out.println("test1: " + result);
	}

	public void test2() {
		String s = "  hello world!  ";
		String result = reverseWords2(s);
		System.out.println("test2: " + result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();

	}

}

/*
 * StringBuilder 与 StringBuffer 的区别： StringBuilder 为非线程安全，适用于单线程，性能好
 * StringBuffer 为线程安全，方法加锁，适用于多线程
 */
