public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ===================算法实现=====================
	// 方法1 递归
	// 时间复杂度O(n)
	// 空间复杂度O(n)，取决于递归深度
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// 边界条件判断
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
			return null;
		}

		TreeNode root = buildTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		return root;
	}

	private TreeNode buildTreeCore(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {

		int value = preorder[start1];
		int temp = start2;
		while (temp < end2) {
			if (inorder[temp] == value) {
				break;
			}
			temp++;
		}

		// 如果数组错误
		if (temp == end2 && inorder[temp] != value) {

		}
		int count = temp - start2;
		TreeNode root = new TreeNode(value);
		if (count == 0) {
			root.left = null;
		} else {
			root.left = buildTreeCore(preorder, start1 + 1, start1 + count, inorder, start2, temp - 1);
		}

		if (end2 - temp == 0) {
			root.right = null;
		} else {
			root.right = buildTreeCore(preorder, start1 + count + 1, end1, inorder, temp + 1, end2);
		}
		return root;
	}

	// 方法2 迭代法
// ===================测试代码=====================
	public void test() {
		int[] preorder = { 1, 2, 3 };
		int[] inorder = { 3, 2, 1 };
		TreeNode root = buildTree(preorder, inorder);
		System.out.println(root);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
