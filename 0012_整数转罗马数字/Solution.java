public class Solution {

// ====================算法实现==================
	// 方法 贪心 + 硬编码
	// 时间复杂度O(1)
	// 空间复杂度O(1)
	public String intToRoman(int num) {

		StringBuffer result = new StringBuffer();
		// 编码字符串，使值与字符串匹配
		int values[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String symbols[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		for (int i = 0; i < values.length; ++i) {
			while (values[i] <= num) {
				num -= values[i];
				result.append(symbols[i]);
			}
		}

		return result.toString();
	}

// ====================测试代码==================
	public void test1() {
		int num = 58;
		String result = intToRoman(num);
		System.out.println("test1：" + result);
	}

	public void test2() {
		int num = 1994;
		String result = intToRoman(num);
		System.out.println("test2：" + result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();

	}

}
