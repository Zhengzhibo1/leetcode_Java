public class Solution {

// ===================算法实现==================
	// 方法 一次遍历
	// 时间复杂度O(n)
	// 空间复杂度O(1)，如果产生溢出，空间复杂度为O(n + 1)，其中n为数组长度
	public int[] plusOne(int[] digits) {

		// 边界条件判断
		if (digits == null || digits.length == 0) {

			return null;
		}

		for (int i = digits.length - 1; i >= 0; --i) {

			if (digits[i] + 1 == 10) { // 进位
				digits[i] = 0;
				continue;
			} else {
				digits[i] += 1;
				return digits;
			}
		}

		// 如果加1溢出
		digits = new int[digits.length + 1];
		digits[0] = 1;

		return digits;
	}

// ===================测试代码==================
	public void test1() {
		int digits[] = { 4, 3, 2, 1 };
		int result[] = plusOne(digits);
		System.out.print("test1：");
		for (int i : result) {
			System.out.print(i);
		}
		System.out.println();
	}

	public void test2() {
		int digits[] = { 9, 9, 9, 9 };
		int result[] = plusOne(digits);
		System.out.print("test2：");
		for (int i : result) {
			System.out.print(i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();
	}

}
