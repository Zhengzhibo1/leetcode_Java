import java.util.Stack;

public class Solution {

// ===================算法实现===================
	// 方法1 递归 + 分治
	// 时间复杂度O(n ^ 2)，n为二叉树的节点数，若最差情况，二叉树为链式，每次递归所需时间复杂度O(n)，递归遍历节点所需时间复杂度O(n)
	// 空间复杂度O(n)，取决于递归深度
	public boolean verifyPostorder(int[] postorder) {

		return dfs(postorder, 0, postorder.length - 1);
	}

	private boolean dfs(int[] postorder, int start, int rootIndex) {

		if (start >= rootIndex) {
			return true;
		}

		int i = start;
		while (postorder[i] < postorder[rootIndex]) {
			i++;
		}
		int m = i;
		while (postorder[i] > postorder[rootIndex]) {
			i++;
		}

		return i == rootIndex && dfs(postorder, start, m - 1) && dfs(postorder, m, rootIndex - 1);
	}

	// 方法2 单调栈
	// 时间复杂度O(n)，n为二叉树的节点数，每个节点遍历一次
	// 空间复杂度O(n)
	public boolean verifyPostorder2(int[] postorder) {
		int root = Integer.MAX_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		// 后续遍历的倒序，即 根节点 + 右子树 + 左子树
		for (int i = postorder.length - 1; i >= 0; --i) {
			if (postorder[i] > root) {
				return false;
			}

			while (!stack.isEmpty() && stack.peek() > postorder[i]) {
				root = stack.pop();
			}

			stack.add(postorder[i]);
		}

		return true;
	}

// ===================测试代码===================
	public void test() {
		int[] postorder = { 1, 3, 2, 6, 5 };
		boolean result = verifyPostorder2(postorder);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
