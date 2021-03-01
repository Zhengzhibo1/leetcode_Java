public class Solution {

// ===================算法实现=====================
	public int nthUglyNumber(int n) {

		int[] nums = new int[n];
		nums[0] = 1;

		int index = 1, index2 = 0, index3 = 0, index5 = 0;
		while (index < n) {
			int n2 = nums[index2] * 2;
			int n3 = nums[index3] * 3;
			int n5 = nums[index5] * 5;
			int min = Math.min(n2, Math.min(n3, n5));
			nums[index++] = min;

			if (min == n2) {
				index2++;
			}

			if (min == n3) {
				index3++;
			}

			if (min == n5) {
				index5++;
			}

		}

		return nums[n - 1];
	}

// ===================测试代码=====================
	public void test() {
		int n = 10;
		int result = nthUglyNumber(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
