public class Solution {

// ====================算法实现======================
	// 总结：
	// 时间复杂度：O(k)，其中k是木板数量，短木板和长木板一共使用k块，一共k+1种组合
	// 空间复杂度：O(1)，除了返回值以外，额外使用的空间复杂度为常数。
	public int[] divingBoard(int shorter, int longer, int k) {

		if (shorter <= 0 || longer <= 0) {
			return null;
		}
		// k等于0返回空数组
		if (k == 0) {
			return new int[0];
		}

		// 长木板等于短木板，则只有一种结果
		if (shorter == longer) {
			return new int[] { shorter * k };
		}

		int[] result = new int[k + 1];
		// 长木板数从0-k，短木板数从k-0，数值依次增大
		for (int i = 0; i <= k; ++i) {
			result[i] = (i * longer + (k - i) * shorter);
		}
		return result;
	}

// ===================测试代码========================
	public static void main(String[] args) {
		Solution s = new Solution();
		int shorter = 1;
		int longer = 2;
		int k = 3;
		int[] result = s.divingBoard(shorter, longer, k);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

}
