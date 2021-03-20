public class Solution {

// ===================算法实现========================
	// 方法 一次遍历
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int strToInt(String str) {

		// 边界条件判断
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] c = str.toCharArray();
		int flag = 1; // 1 表示整数，-1表示负数
		int result = 0;
		int index = 0;
		int boundary = Integer.MAX_VALUE / 10;
		while (index < c.length && c[index] == ' ') {
			index++;
		}
		if (index == c.length) {
			return 0;
		}

		if (c[index] == '-') {
			flag = -1;
		}
		if (c[index] == '-' || c[index] == '+') {
			index++;
		}

		for (int i = index; i < c.length; ++i) {
			if (c[i] < '0' || c[i] > '9') {
				// 非数字
				break;
			}
			if (result > boundary || (result == boundary && c[i] > '7')) {
				// 越界
				return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}

			result = result * 10 + c[i] - '0';
		}

		return result * flag;
	}

// ===================测试代码========================
	public void test() {
		String str = "     -4193 with words";
		int result = strToInt(str);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
