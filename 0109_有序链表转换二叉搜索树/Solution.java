public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

// ===================算法实现==================
	// 方法1 分治
	// 时间复杂度O(n logN)，其中n为节点数，遍历每个节点，寻找分段链表的中位数
	// 空间复杂度O(logN)，递归深度
	public TreeNode sortedListToBST(ListNode head) {
		return buildTree(head, null);
	}

	private TreeNode buildTree(ListNode left, ListNode right) {
		if (left == right) {
			return null;
		}
		ListNode mid = getMedian(left, right);
		TreeNode root = new TreeNode(mid.val);
		root.left = buildTree(left, mid);
		root.right = buildTree(mid.next, right);

		return root;
	}

	// 获取链表中间节点
	private ListNode getMedian(ListNode left, ListNode right) {
		ListNode fast = left;
		ListNode slow = left;
		while (fast != right && fast.next != right) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	// 方法2 分治 + 中序遍历
	// 时间复杂度O(n)，每个节点遍历一次
	// 空间复杂度O(logN)，递归深度
	// 全部遍历
	ListNode globalHead = null;

	public TreeNode sortedListToBST2(ListNode head) {
		globalHead = head;
		int length = getLength(head);
		return buildTree2(0, length - 1);
	}

	// 获取当前链表长度
	private int getLength(ListNode node) {
		int length = 0;
		while (node != null) {
			++length;
			node = node.next;
		}

		return length;
	}

	private TreeNode buildTree2(int left, int right) {
		if (left > right) {
			return null;
		}

		int mid = (left + right + 1) >> 1;
		TreeNode root = new TreeNode();
		root.left = buildTree2(left, mid - 1);
		root.val = globalHead.val;
		globalHead = globalHead.next;
		root.right = buildTree2(mid + 1, right);
		return root;
	}

// ===================测试代码==================
	private void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.val + "\t");
		inOrder(root.right);
	}

	public void test() {
		ListNode node1 = new ListNode(-10);
		ListNode node2 = new ListNode(-3);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(9);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		TreeNode root = sortedListToBST2(node1);
		inOrder(root);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
