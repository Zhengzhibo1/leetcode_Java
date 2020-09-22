public class Solution {

// ===================算法实现=====================
	// 1 取模求和
	// 32位固定
	// 时间复杂度O(1)
	// 空间复杂度O(1)
	public int reverseBits(int n) {
		int result = 0;

		for (int i = 0; i < 32; ++i) {
			result = (result << 1) + (n & 1);
			n = n >> 1;
		}

		return result;
	}

	// 2 按位翻转
	// 时间复杂度O(1)
	// 空间复杂度O(1)
	// 如果n的第i位为1，则result的第31-i位为1
	public int reverseBits2(int n) {
		int result = 0;

		for (int i = 0; i < 32; ++i) {
			result ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
		}

		return result;
	}

// ===================测试代码=====================
	public void test() {
		int n = -3;
		int result = reverseBits2(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
