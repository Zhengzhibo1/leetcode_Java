public class Solution {

// ===================算法实现===================
	// 方法1 先翻转整句，再翻转每一个单词
	// 时间复杂度O(n)，n为字符串的长度
	// 空间复杂度O(n)
	public String reverseWords(String s) {

		// 边界条件判断
		if (s == null || s.length() == 0) {
			return s;
		}

		char[] chars = s.toCharArray();
		// 翻转整句
		reverse(chars, 0, chars.length - 1);
		int start = 0, end = 0, index = 0;

		StringBuilder sb = new StringBuilder();
		while (index < chars.length) {
			// 找到不为空的字符串
			while (index < chars.length && chars[index] == ' ') {
				start++;
				index++;
			}

			end = start;
			while (index < chars.length && chars[index] != ' ') {
				end++;
				index++;
			}

			reverse(chars, start, end - 1);
			for (int i = start; i < end; ++i) {
				sb.append(chars[i]);
			}

			sb.append(' ');
			start = end;
		}

		// 删除最后多余空格
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
			sb.deleteCharAt(sb.length() - 1);
		}

		return sb.toString();
	}

	private void reverse(char[] chars, int start, int end) {

		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;

			start++;
			end--;
		}
	}

	// 方法2 双指针法
	// 时间复杂度O(n)，n为字符串的长度
	// 空间复杂度O(n)
	public String reverseWords2(String s) {

		// 边界条件判断
		if (s == null || s.length() == 0) {
			return s;
		}

		char[] chars = s.toCharArray();

		// 首先去掉首尾空格
		int start = 0;
		int end = chars.length - 1;
		while (start < chars.length && chars[start] == ' ') {
			start++;
		}

		while (end >= 0 && chars[end] == ' ') {
			end--;
		}

		int left = end, right = end;
		StringBuilder sb = new StringBuilder();
		while (left >= start) {
			while (left >= start && chars[left] != ' ') {
				left--;
			}
			sb.append(chars, left + 1, right - left);
			sb.append(' ');
			while (left >= start && chars[left] == ' ') {
				left--;
			}
			right = left;
		}

		// 删除最后多余空格
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
			sb.deleteCharAt(sb.length() - 1);
		}

		return sb.toString();
	}

// ===================测试代码===================
	public void test() {
		String s = "  hello world!  ";
		String result = reverseWords2(s);
		System.out.println(result);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
