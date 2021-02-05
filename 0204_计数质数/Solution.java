public class Solution {

// ===================算法实现====================
	public int countPrimes(int n) {

		int count = 0;
		for (int i = 2; i < n; ++i) {
			if (isPrimes(i)) {
				count += 1;
			}
		}

		return count;
	}

	private boolean isPrimes(int n) {

		for (int i = 2; i * i <= n; ++i) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

// ===================测试代码====================
	public void test() {
		int n = 10;
		int count = countPrimes(n);
		System.out.println(count);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
