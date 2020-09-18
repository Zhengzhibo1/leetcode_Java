public class Solution {

// ====================算法实现===================
	// 1
	// 时间复杂度O(n)
	// 空间复杂度取决于StringBuffer
	public String countAndSay(int n) {

		String pre = "1";
		if (n == 1) {
			return pre;
		}

		StringBuffer temp = new StringBuffer();
		for (int i = 1; i < n; ++i) {
			int index = 0;
			while (index < pre.length()) {
				char c = pre.charAt(index);
				int count = 0;
				while (index < pre.length() && c == pre.charAt(index)) {
					count++;
					index++;
				}
				temp.append(count);
				temp.append(c);
			}

			pre = temp.toString();
			temp = new StringBuffer();
		}

		return pre;
	}

	// 递归 + 双指针
	// 时间复杂度O(n)
	// 空间复杂度O(n)，取决于递归深度
	public String countAndSay2(int n) {
		if (n == 1) {
			return "1";
		}

		StringBuffer res = new StringBuffer();
		// 拿上一层字符串
		String str = countAndSay2(n - 1);
		int length = str.length();

		int start = 0;
		for (int i = 1; i <= length; ++i) {
			// 字符串最后一位直接拼接
			if (i == length) {
				res.append(i - start).append(str.charAt(start));
			} else if (str.charAt(start) != str.charAt(i)) {
				res.append(i - start).append(str.charAt(start));
				start = i;
			}
		}

		return res.toString();
	}

// ====================测试代码====================
	public void test() {
		int n = 4;
		String result = countAndSay2(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
