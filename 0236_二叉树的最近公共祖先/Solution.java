import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ====================算法实现===================
	// 1 双链表 求最后一个公共节点
	// 时间复杂度O(n)，n为节点数，找链表需要遍历两次树
	// 空间复杂度O(n)，最差情况，平均情况为O(log n)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// 边界条件判断
		if (root == null) {
			return null;
		}

		List<TreeNode> pPath = new ArrayList<TreeNode>();
		List<TreeNode> qPath = new ArrayList<TreeNode>();

		TreeNode result = null;
		if (getNodePath(root, p, pPath) && getNodePath(root, q, qPath)) {
			int index1 = 0, index2 = 0;
			while (index1 < pPath.size() && index2 < qPath.size()) {
				if (pPath.get(index1).val == qPath.get(index2).val) {
					result = pPath.get(index1);
					index1++;
					index2++;
				} else {
					break;
				}
			}
		}

		return result;
	}

	boolean getNodePath(TreeNode root, TreeNode target, List<TreeNode> path) {
		if (root == target) {
			path.add(root);
			return true;
		}

		path.add(root);
		boolean found = false;

		if (root.left != null) {
			found = getNodePath(root.left, target, path);
		}

		if (!found && root.right != null) {
			found = getNodePath(root.right, target, path);
		}

		if (!found) {
			path.remove(path.size() - 1);
		}

		return found;
	}

	// 2 递归
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	TreeNode result = null;

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

		dfs(root, p, q);
		return result;
	}

	public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return false;
		}

		boolean lson = dfs(root.left, p, q);
		boolean rson = dfs(root.right, p, q);
		if ((lson && rson) || ((lson || rson) && (root.val == p.val || root.val == q.val))) {
			result = root;
		}

		return lson || rson || (root.val == p.val || root.val == q.val);
	}

	// 3 哈希表存储父节点
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
	Set<Integer> set = new HashSet<Integer>();

	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return null;
		}

		dfs2(root);
		while (p != null) {
			set.add(p.val);
			p = map.get(p.val);
		}

		while (q != null) {
			if (set.contains(q.val)) {
				return q;
			}
			q = map.get(q.val);
		}

		return null;
	}

	public void dfs2(TreeNode root) {
		if (root.left != null) {
			map.put(root.left.val, root);
			dfs2(root.left);
		}

		if (root.right != null) {
			map.put(root.right.val, root);
			dfs2(root.right);
		}
	}

// ====================测试代码===================
	public void test() {
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);

		node3.left = node5;
		node3.right = node1;

		node5.left = node6;
		node5.right = node2;

		node2.left = node7;
		node2.right = node4;

		node1.left = node0;
		node1.right = node8;

		TreeNode root = node3;
		TreeNode p = node5;
		TreeNode q = node4;

		TreeNode result = lowestCommonAncestor(root, p, q);
		System.out.println(result.val);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
