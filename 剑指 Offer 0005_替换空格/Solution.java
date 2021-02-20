public class Solution {

// ===================算法实现======================
	// 方法 一次遍历
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public String replaceSpace(String s) {

		StringBuilder sb = new StringBuilder();
		int length = s.length();
		for (int i = 0; i < length; ++i) {

			if (s.charAt(i) == ' ') {
				sb.append("%20");
				continue;
			}

			sb.append(s.charAt(i));
		}

		return sb.toString();
	}

// ===================测试代码======================
	public void test() {
		String s = "We are happy.";
		String result = replaceSpace(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
