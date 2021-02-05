public class Solution {

// ====================算法实现====================
	// 方法 从后往前遍历
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int lengthOfLastWord(String s) {

		// 边界条件判断
		if (s == null || s.length() == 0 || s.equals(" ")) {
			return 0;
		}

		int end = s.length() - 1;
		int count = 0;
		char chars[] = s.toCharArray();

		// 如果全是空
		boolean flag = true;
		for (int i = 0; i < chars.length; ++i) {
			if (chars[i] != ' ') {
				flag = false;
				break;
			}
		}

		if(flag) {
			return 0;
		}
		
		while (chars[end] == ' ') {
			end--;
		}

		while (end >= 0 && chars[end] != ' ') {
			count++;
			end--;
		}

		return count;
	}

	// 改进
	public int lengthOfLastWord2(String s) {
		int end = s.length() - 1;
		while(end >= 0 && s.charAt(end) == ' ') {
			end--;
		}
		
		if(end < 0) {
			return 0;
		}
		
		int start = end;
		while(start >= 0 && s.charAt(start) != ' ') {
			start--;
		}
		
		return end - start;
	}
// ====================测试代码====================
	public void test1() {
		String s = "Hello World";
		int result = lengthOfLastWord(s);
		System.out.println(result);
	}

	public void test2() {
		String s = "        ";
		int result = lengthOfLastWord(s);
		System.out.println(result);
	}
	
	public void test3() {
		String s = "a";
		int result = lengthOfLastWord(s);
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();
		s.test3();
	}

}
