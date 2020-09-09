public class Solution {

// ====================算法实现====================
	// 1 26进制
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int titleToNumber(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int result = 0;
		for (int i = 0; i < s.length(); ++i) {
			result *= 26;
			char temp = s.charAt(i);
			result += temp - 'A' + 1;
		}

		return result;
	}

// ====================测试代码====================
	public void test() {
		String s = "ZY";
		int result = titleToNumber(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
