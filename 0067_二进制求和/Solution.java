public class Solution {

// =====================算法实现==================
	// 1 字符串模拟二进制加法
	// 时间复杂度O(Max(M, N))，M与N为两字符串长度
	// 空间复杂度O(Max(M, N))，StringBuilder存放临时结果
	public String addBinary(String a, String b) {
		int indexA = a.length() - 1;
		int indexB = b.length() - 1;

		StringBuilder result = new StringBuilder();
		// 进位
		int carry = 0;
		while (indexA >= 0 && indexB >= 0) {
			int sum = carry;
			sum += a.charAt(indexA--) - '0';
			sum += b.charAt(indexB--) - '0';
			carry = sum / 2;
			result.append(sum % 2);
		}

		// 如果a还有
		while (indexA >= 0) {
			int sum = carry;
			sum += a.charAt(indexA--) - '0';
			carry = sum / 2;
			result.append(sum % 2);
		}

		// 如果b还有
		while (indexB >= 0) {
			int sum = carry;
			sum += b.charAt(indexB--) - '0';
			carry = sum / 2;
			result.append(sum % 2);
		}

		// 如果加完之后进位为1，需要补上
		if (carry == 1) {
			result.append(carry);
		}

		return result.reverse().toString();
	}

// =====================测试代码==================
	public void test() {
		String a = "1010", b = "1011";
		String result = addBinary(a, b);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
