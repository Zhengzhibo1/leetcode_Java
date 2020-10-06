import java.util.HashMap;
import java.util.Map;

public class Solution {

// ====================算法实现======================
	// 1 存A,B 计算C,D
	// 时间复杂度O(n^2)
	// 空间复杂度O(n^2)
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

		int length = A.length;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// 存A,B
		for (int index1 = 0; index1 < length; index1++) {
			for (int index2 = 0; index2 < length; index2++) {
				map.put(A[index1] + B[index2], map.getOrDefault(A[index1] + B[index2], 0) + 1);
			}
		}

		// 算C,D
		for (int index3 = 0; index3 < length; ++index3) {
			for (int index4 = 0; index4 < length; ++index4) {
				int curSum = -C[index3] - D[index4];
				if (map.containsKey(curSum)) {
					count += map.get(curSum);
				}
			}
		}

		return count;
	}

// ====================测试代码======================
	public void test() {
		int[] A = { 1, 2 };
		int[] B = { -2, -1 };
		int[] C = { -1, 2 };
		int[] D = { 0, 2 };
		int result = fourSumCount(A, B, C, D);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
