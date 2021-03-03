public class Solution {

// ===================算法实现=======================
	// 方法 递归
	// 时间复杂度O(n)
	// 空间复杂度O(n)，取决于递归深度
	public int sumNums(int n) {

		boolean b = n > 1 && (n += sumNums(n - 1)) > 0;
		return n;

	}

// ===================测试代码=======================
	public void test() {
		int n = 10;
		int sum = sumNums(n);
		System.out.println(sum);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
