public class Solution {

// ===================算法实现====================
	public boolean isUgly(int num) {

		if (num < 1) {
			return false;
		}

		while (num % 2 == 0) {
			num /= 2;
		}

		while (num % 3 == 0) {
			num /= 3;
		}

		while (num % 5 == 0) {
			num /= 5;
		}

		return num == 1;
	}

// ===================测试代码====================
	public void test() {
		int num = 10;
		boolean result = isUgly(num);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
