public class Solution {

// ===================算法实现===================
	// 方法 二分查找
	// 时间复杂度O(log x)
	// 空间复杂度O(1)
	public int mySqrt(int x) {

		int start = 0, end = x, mid = 0, result = 0;
		while (start <= end) {
			mid = start + ((end - start) >> 1);
			// 注意计算前，将数字转换成长整型
			if ((long)mid * mid <= x) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}

// ===================测试代码===================
	public void test() {
		int x1 = 4;
		int x2 = 10;
		System.out.println(mySqrt(x1));
		System.out.println(mySqrt(x2));
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}
