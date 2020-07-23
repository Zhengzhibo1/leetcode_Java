public class Solution {

// ====================算法实现===================
	// 1 动态规划
	// 时间复杂度O(n^2)，其中n表示二叉搜索树的节点个数
	// G(n)函数一共有n个值需要求解，每次求解需要O(n)的时间复杂度
	// 空间复杂度O(n),需要O(n)的空间存储G数组
	public int numTrees(int n) {

		int G[] = new int[n + 1];
		G[0] = 1;
		G[1] = 1;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				G[i] += G[j - 1] * G[i - j];
			}
		}

		return G[n];
	}

// ====================测试代码===================
	public static void main(String[] args) {
		Solution s = new Solution();
		int result = s.numTrees(3);
		System.out.println(result);
	}

}
