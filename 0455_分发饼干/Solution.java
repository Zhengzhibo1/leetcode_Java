import java.util.Arrays;

public class Solution {

// ====================算法实现=====================
	// 方法 排序 + 贪心
	// 时间复杂度O(N log N + M log M)，其中 N， M 为数组长度，排序所需时间复杂度
	// 空间复杂度O(log N + log M)，排序所需
	public int findContentChildren(int[] g, int[] s) {

		// 对两数组排序
		Arrays.sort(g);
		Arrays.sort(s);

		int numOfChildren = g.length;
		int numOfCookies = s.length;

		int count = 0;
		for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; ++i, ++j) {
			while (j < numOfCookies && g[i] > s[j]) {
				j++;
			}
			if (j < numOfCookies) {
				count++;
			}
		}

		return count;
	}

// ====================测试代码=====================
	public void test() {
		int g[] = { 1, 2, 3 };
		int s[] = { 1, 1 };

		int count = findContentChildren(g, s);
		System.out.println(count);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
