public class Solution {

// ===================算法实现====================
	// 方法 模9法
	// 时间复杂度O(1)
	// 空间复杂度O(2)
	public int addDigits(int num) {

		return (num - 1) % 9 + 1;
	}

// ===================测试代码====================
	public void test() {
		int num = 1024;
		System.out.println(addDigits(num));
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}258. 各位相加
