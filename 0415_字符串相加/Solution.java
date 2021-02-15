public class Solution {

// ===================算法实现==================
	// 模拟 一次遍历
	// 时间复杂度O(max(M, N))，M、N分别位两个字符串的长度
	// 时间复杂度O(max(M, N))
	public String addStrings(String num1, String num2) {

		StringBuilder sb = new StringBuilder();
		// 保证1的长度大于2
		if (num1.length() < num2.length()) {
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}

		int carry = 0;
		int index2 = num2.length() - 1;
		int index1 = num1.length() - 1;
		while (index2 >= 0) {
			int temp1 = num1.charAt(index1) - '0';
			int temp2 = num2.charAt(index2) - '0';

			int curSum = temp1 + temp2 + carry;
			if (curSum > 9) {
				carry = 1;
				curSum -= 10;
			} else {
				carry = 0;
			}

			sb.append(curSum);
			index2--;
			index1--;
		}

		while (index1 >= 0) {
			int temp = num1.charAt(index1) - '0';
			int curSum = temp + carry;
			if (curSum > 9) {
				carry = 1;
				curSum -= 10;
			} else {
				carry = 0;
			}

			sb.append(curSum);
			index1--;
		}

		if (carry > 0) {
			sb.append(carry);
		}

		sb.reverse();
		return sb.toString();
	}

// ===================测试代码==================
	public void test() {
		String num1 = "999";
		String num2 = "1";
		String sum = addStrings(num1, num2);
		System.out.println(sum);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
