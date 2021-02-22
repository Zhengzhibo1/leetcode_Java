public class Solution {

// ===================算法实现=====================
	// 方法1 去掉n的最后一个1
	// 时间复杂度O(1)，n为int类型，最多32位
	// 空间复杂度O(1)
	public int hammingWeight(int n) {

		int count = 0;
		while (n != 0) {
			// 去掉n的最后一个1
			n = n & (n - 1);
			count++;
		}

		return count;
	}

	// 方法2 逐位判断
	// 时间复杂度O(1)
	// 空间复杂度O(1)
	// 注意事项：>> 有符号右移，若n为正，右移高位补0，若n为负，右移高位补1，>>> 无符号移动，高位补0
	public int hammingWeight2(int n) {

		int count = 0;
		while (n != 0) {
			count += n & 1;
			n = n >>> 1;
		}

		return count;
	}

// ===================测试代码=====================
	public void test() {
		int n = -1;
		int count = hammingWeight2(n);
		System.out.println(count);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
