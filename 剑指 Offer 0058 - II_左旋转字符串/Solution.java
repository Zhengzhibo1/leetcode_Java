public class Solution {

// ===================算法实现====================
	// 方法1 字符串遍历
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public String reverseLeftWords(String s, int n) {

		int length = s.length();
		n = n % length;
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = n; i < chars.length; ++i) {
			sb.append(chars[i]);
		}

		for (int i = 0; i < n; ++i) {
			sb.append(chars[i]);
		}

		return sb.toString();
	}

	// 方法2 取余
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public String reverseLeftWords2(String s, int n) {

		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		int length = s.length();
		for (int i = n; i < n + length; ++i) {
			sb.append(chars[i % length]);
		}

		return sb.toString();
	}

// ===================测试代码====================
	public void test() {
		String s = "abcdefg";
		int n = 2;
		String result = reverseLeftWords2(s, n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
