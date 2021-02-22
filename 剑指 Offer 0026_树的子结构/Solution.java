public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ===================算法实现======================
	// 方法 递归，先递归找到值相同的节点，再递归判断是否为子树
	// 时间复杂度O(NM)，N为A树的节点数，M为B树的节点数
	// 空间复杂度O(N),取决于递归深度
	public boolean isSubStructure(TreeNode A, TreeNode B) {

		boolean flag = false;
		if (A != null && B != null) {

			if (A.val == B.val) {
				flag = doesHaveSub(A, B);
			}

			if (flag != true) {
				flag = isSubStructure(A.left, B);
			}

			if (flag != true) {
				flag = isSubStructure(A.right, B);
			}
		}

		return flag;
	}

	private boolean doesHaveSub(TreeNode A, TreeNode B) {
		if (B == null) {
			return true;
		}

		if (A == null || A.val != B.val) {
			return false;
		}

		return doesHaveSub(A.left, B.left) && doesHaveSub(A.right, B.right);
	}

// ===================测试代码======================
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node3.left = node4;
		node3.right = node5;
		node4.left = node1;
		node4.right = node2;

		boolean result = isSubStructure(node3, node4);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
