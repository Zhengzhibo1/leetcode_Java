public class Solution {

// ====================算法实现====================
	// 1 自带计数器
	// 时间复杂度O(1)，整型位数固定
	// 空间复杂度O(1)
	public int hammingWeight(int n) {
		return Integer.bitCount(n);
	}

	// 2 数字右移
	// 时间复杂度O(1)
	// 空间复杂度O(1)
	public int hammingWeight2(int n) {
		int count = 0;
		for (int i = 0; i < 32; ++i) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}

		return count;
	}

	// 3 标志位左移
	// 时间复杂度O(1)
	// 空间复杂度O(1)
	public int hammingWeight3(int n) {
		int mask = 1;
		int count = 0;

		for (int i = 0; i < 32; ++i) {
			if ((n & mask) != 0) {
				count++;
			}
			mask = mask << 1;
		}

		return count;
	}

	// 4
	// 时间复杂度O(1)
	// 空间复杂度O(1)
	public int hammingWeight4(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}

		return count;
	}

// ====================测试代码====================
	public void test() {
		int n = 11;
		int res = hammingWeight3(n);
		System.out.println(res);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}
