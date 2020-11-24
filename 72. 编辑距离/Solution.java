public class Solution {

// ====================算法实现===================
	/*
	 * 方法：动态规划 A = “horse” B = “ros” 假设单词B不动，仅改变单词A （1）在A中插入一个字符
	 * 假设horse到ro的编辑距离为a，那么horse到ros的编辑距离最小为a + 1，
	 * 因为经过a距离后，horse变成了ro，仅需一步就可以让ro变成ros （2）在A中删除一个字符
	 * 假设hors到ros的编辑距离为b，那么horse到ros的编辑距离最小为b + 1，
	 * 因为经过b距离后，horse变成了rose，仅需一步rose就变成ros （3）在A中修改一个字符
	 * 假设hors到ro的编辑距离为c，那么horse到ros的编辑距离最小为c + 1，
	 * 因为经过c距离后，horse变成了roe，仅需一步roe就能变成ros 注意：若最后一个字符相同，即horse到roe的编辑距离为c。
	 * 
	 * 故A到B的编辑距离为min(a+1, b+1, c+1(或c))
	 */
	public int minDistance(String word1, String word2) {

		// n表示第一个单词的长度，m表示第二个单词的长度
		int n = word1.length();
		int m = word2.length();

		// 边界条件判断，如果有一个空串，则返回非空串长度
		if (n * m == 0) {
			return n + m;
		}

		// DP数组
		int D[][] = new int[n + 1][m + 1];
		// 初始化边界状态
		for (int i = 0; i <= n; ++i) {
			D[i][0] = i;
		}
		for (int j = 0; j <= m; ++j) {
			D[0][j] = j;
		}

		// 计算所有DP的值
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				// A中删除一个字符
				int distance1 = D[i - 1][j] + 1;
				// A中增加一个字符
				int distance2 = D[i][j - 1] + 1;
				int distance3 = D[i - 1][j - 1];
				// 如果最后一个字符不相等，则需要加一步操作，即变换字符
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
					distance3++;
				}
				// 算出第一个单词第i个字符到第二个单词第j个字符的编辑距离
				D[i][j] = Math.min(distance1, Math.min(distance2, distance3));
			}
		}

		return D[n][m];
	}

// ====================测试代码========================
	public void test1() {
		String word1 = "horse";
		String word2 = "ros";
		int result = minDistance(word1, word2);
		System.out.println("测试1的结果为：" + result);
	}

	public void test2() {
		String word1 = "intention";
		String word2 = "execution";
		int result = minDistance(word1, word2);
		System.out.println("测试2的结果为：" + result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();

	}

}
