public class Solution {

// ===================算法实现=====================
	// 方法 数组
	// 时间复杂度O(n)，n为s的长度
	// 空间复杂度O(n)
	public char firstUniqChar(String s) {

		int[] counts = new int[26];
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; ++i) {
			counts[chars[i] - 'a']++;
		}

		char result = ' ';
		for (int i = 0; i < chars.length; ++i) {
			if (counts[chars[i] - 'a'] == 1) {
				result = chars[i];
				break;
			}
		}
		return result;
	}

// ===================测试代码=====================
	public void test() {
		String s = "abaccdeff";
		char c = firstUniqChar(s);
		System.out.println(c);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
