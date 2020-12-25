public class Solution {

// ===================算法实现===========================
	// 方法1 暴力法
	// 时间复杂度O((N - L)L)，其中N为匹配串长度，L为模式串味道
	// 空间复杂度O(1)
	public int strStr(String haystack, String needle) {

		// 边界条件判断
		if (needle == null || needle.length() == 0) {
			return 0;
		}

		if (haystack == null || haystack.length() == 0) {
			return -1;
		}

		// 进行匹配
		int N = haystack.length();
		int L = needle.length();

		for (int i = 0; i <= N - L; ++i) {
			for (int j = 0; j < L; ++j) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
				// 如果完全匹配，返回起始位置
				if (j == L - 1) {
					return i;
				}
			}
		}

		return -1;
	}

	// 方法2 哈希码
	// 时间复杂度O(N)，其中N为匹配串长度
	// 空间复杂度O(1)
	private int charToInt(int index, String s) {
		return s.charAt(index) - 'a';
	}

	public int strStr2(String haystack, String needle) {
		// 边界条件判断
		if (needle == null || needle.length() == 0) {
			return 0;
		}

		if (haystack == null || haystack.length() == 0) {
			return -1;
		}

		int N = haystack.length();
		int L = needle.length();
		// 边界条件判断
		if (L > N) {
			return -1;
		}

		// 26个字母
		int num = 26;
		// 取模，防止大数溢出
		long modulus = (long) Math.pow(2, 31);

		long hash = 0, refHash = 0;
		// 生成哈希码
		for (int i = 0; i < L; ++i) {
			refHash = (refHash * num + charToInt(i, needle)) % modulus;
			hash = (hash * num + charToInt(i, haystack)) % modulus;
		}

		if (hash == refHash) {
			return 0;
		}

		long aL = 1;
		for (int i = 0; i < L; ++i) {
			aL = (aL * num) % modulus;
		}

		// 滑动窗口生成哈希码
		for (int start = 1; start <= N - L; ++start) {
			hash = (hash * num - charToInt(start - 1, haystack) * aL + charToInt(start + L - 1, haystack)) % modulus;
			if (hash == refHash) {
				return start;
			}
		}

		return -1;
	}

// ===================测试代码============================
	public void test() {
		String haystack = "hello";
		String needle = "ll";
		int result = strStr2(haystack, needle);

		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
