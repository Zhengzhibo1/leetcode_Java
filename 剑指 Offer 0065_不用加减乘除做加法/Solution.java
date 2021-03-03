public class Solution {

// ===================算法实现===================
	// 与运算，进位位
	// 异或运算，相加
	public int add(int a, int b) {

		while (b != 0) {
			// 进位位
			int carry = (a & b) << 1;
			a = a ^ b;
			b = carry;
		}

		return a;
	}

// ===================测试代码===================
	public void test() {
		int a = 1, b = 2;
		int sum = add(a, b);
		System.out.println(sum);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
