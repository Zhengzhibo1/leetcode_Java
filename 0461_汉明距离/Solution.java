public class Solution {

// ====================算法实现===================
	// 1 内置位计数功能
	// 时间复杂度O(1)，因为JAVA的Integer长度固定
	// 空间复杂度O(1)
	public int hammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
	}

	// 2 异或 移位统计
	// 时间复杂度O(1)，Integer固定长度
	// 空间复杂度O(1)
	public int hammingDistance2(int x, int y) {
		int temp = x ^ y;
		int count = 0;

		while (temp != 0) {
			if ((temp & 1) == 1) {
				count++;
			}
			temp = temp >> 1;
		}
		return count;
	}

	// 布莱恩·克尼根算法
	// 时间复杂度O(1)，同理
	// 空间复杂度O(1)
	public int hammingDistance3(int x, int y) {
		int temp = x ^ y;
		int count = 0;
		while (temp != 0) {
			count += 1;
			// temp = 10001000, temp - 1 = 10000111
			// temp & (temp - 1) = 10000000
			temp = temp & (temp - 1);
		}
		return count;
	}

// ====================测试代码===================
	public void test() {
		int x = 1, y = 4;
		int result = hammingDistance(x, y);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
