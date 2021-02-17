public class Solution {

// ===================算法实现==================
	// 方法 多指针遍历
	// 时间复杂度O(k * n)，k为质数数组的长度
	// 空间复杂度(n)
	public int nthSuperUglyNumber(int n, int[] primes) {

		int size = primes.length;
		int[] nums = new int[n];
		nums[0] = 1;

		int[] indexs = new int[size];

		for (int i = 1; i < n; ++i) {

			int ugly = Integer.MAX_VALUE;
			for (int j = 0; j < size; ++j) {
				ugly = Math.min(ugly, nums[indexs[j]] * primes[j]);
			}
			nums[i] = ugly;

			// 任何产生该丑数值得索引均加+1，防止产生重复的值
			for (int j = 0; j < size; ++j) {
				if (ugly == nums[indexs[j]] * primes[j]) {
					indexs[j]++;
				}
			}

		}

		return nums[n - 1];
	}

// ===================测试代码==================
	public void test() {
		int n = 12;
		int[] primes = { 2, 7, 13, 19 };
		int result = nthSuperUglyNumber(n, primes);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
