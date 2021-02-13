public class Solution {

// ====================算法实现========================
	// 方法 滑动数组
	// 时间复杂度O((N + M) * MIN(M, N))
	// 空间复杂度O(1)
	public int findLength(int[] A, int[] B) {

		int lengthA = A.length;
		int lengthB = B.length;
		int result = 0;
		for (int i = 0; i < lengthA; ++i) {
			int len = Math.min(lengthA - i, lengthB);
			int maxlen = maxLen(A, B, i, 0, len);
			result = Math.max(result, maxlen);
		}

		for (int i = 0; i < lengthB; ++i) {
			int len = Math.min(lengthA, lengthB - i);
			int maxlen = maxLen(A, B, 0, i, len);
			result = Math.max(result, maxlen);
		}

		return result;
	}

	private int maxLen(int[] A, int[] B, int indexA, int indexB, int len) {
		int result = 0;
		int temp = 0;
		for (int i = 0; i < len; ++i) {
			if (A[indexA + i] == B[indexB + i]) {
				temp++;
			} else {
				temp = 0;
			}

			result = Math.max(result, temp);
		}

		return result;
	}

// ====================测试代码========================
	public void test() {
		int[] A = { 1, 2, 3, 2, 1 };
		int[] B = { 3, 2, 1, 4, 7 };
		int length = findLength(A, B);
		System.out.println(length);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
