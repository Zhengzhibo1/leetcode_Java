public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ===================算法实现===================
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
			return null;
		}

		return buildTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode buildTreeCore(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		int temp = preorder[preStart];
		int index = inStart;

		// 找到前序遍历的第一个节点在中序遍历中的位置
		while (inorder[index] != temp && index < inEnd) {
			index++;
		}
		// 如果最后一个节点也不相等，则输入数组有误
//    	if(index == inEnd && temp != inorder[inEnd]) {
//    		return null;
//    	}

		TreeNode curNode = new TreeNode(temp);
		int leftLength = index - inStart;
		int rightLength = inEnd - index;

		if (leftLength > 0) {
			curNode.left = buildTreeCore(preorder, preStart + 1, preStart + leftLength, inorder, inStart, index - 1);
		}
		if (rightLength > 0) {
			curNode.right = buildTreeCore(preorder, preStart + leftLength + 1, preEnd, inorder, index + 1, inEnd);
		}

		return curNode;
	}

// ===================测试代码===================
	public void test() {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		TreeNode root = buildTree(preorder, inorder);
		preorder(root);
	}

	public void preorder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + "\t");
		preorder(root.left);
		preorder(root.right);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
