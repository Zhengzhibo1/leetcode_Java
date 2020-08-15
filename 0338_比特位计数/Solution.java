public class Solution {

// ====================算法实现====================
	// 1 整数型自带计数器
	// 整数型位数固定
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int[] countBits(int num) {

		int[] results = new int[num + 1];
		for (int i = 0; i <= num; ++i) {
			results[i] = Integer.bitCount(i);
		}

		return results;
	}

	// 2 汉明权重
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int[] countBits2(int num) {

		int[] results = new int[num + 1];
		for (int i = 0; i <= num; ++i) {
			results[i] = popcount(i);
		}

		return results;
	}

	public int popcount(int x) {
		int count = 0;
		while (x != 0) {
			count++;
			x = x & (x - 1);
		}

		return count;
	}

	// 方法3 动态规划 + 最高有效位
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int[] countBits3(int num) {
		int[] results = new int[num + 1];
		int i = 0, b = 1;
		while (b <= num) {
			while (i < b && i + b <= num) {
				results[i + b] = results[i] + 1;
				++i;
			}
			i = 0;
			b <<= 1;
		}
		return results;
	}

	// 方法4 动态规划 + 最低有效位
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int[] countBits4(int num) {
		int[] results = new int[num + 1];
		for (int i = 1; i <= num; ++i) {
			results[i] = results[i >> 1] + (i & 1);
		}

		return results;
	}

	// 方法5 动态规划 + 最后设置位
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int[] countBits5(int num) {
		int[] results = new int[num + 1];
		for (int i = 1; i <= num; ++i) {
			results[i] = results[i & (i - 1)] + 1;
		}

		return results;
	}

// ====================测试代码====================
	public void test() {
		int num = 2;
		int[] results = countBits5(num);
		for (int i : results) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
