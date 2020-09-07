public class Solution {

// ====================算法实现==================
	// 1 双指针
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public void reverseString(char[] s) {

		if (s == null || s.length == 0) {
			return;
		}

		int begin = 0;
		int end = s.length - 1;

		while (begin < end) {
			char temp = s[begin];
			s[begin] = s[end];
			s[end] = temp;

			begin++;
			end--;
		}
	}

// ====================测试代码==================
	public void test() {
		char[] s = { 'h', 'e', 'l', 'l', 'o' };
		reverseString(s);
		for (char c : s) {
			System.out.print(c + "\t");
		}

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
