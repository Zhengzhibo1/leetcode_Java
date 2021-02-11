public class Solution {

// ====================算法实现=====================
	// 方法 异或
	public int findComplement(int num) {

		int count = 0;
		int temp = num;
		while (temp > 0) {
			count++;
			temp = temp >> 1;
		}

		return num ^ ((1 << count) - 1);
	}

// ====================测试代码=====================
	public void test() {

		int num = 5;
		int result = findComplement(num);
		System.out.println(result);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
