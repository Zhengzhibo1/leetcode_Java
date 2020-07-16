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

// ====================算法实现=================
	// 1 递归
	// 时间复杂度O(M + N)，其中M和N分别为两个两个链表的长度
	// 空间复杂度O(M + N)，递归调用函数时需要消耗栈空间，
	// 栈空间的大小取决于递归调用的深度，此处至多调用M+N次
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode curNode = new ListNode();
		if (l1.val <= l2.val) {
			curNode.val = l1.val;
			curNode.next = mergeTwoLists(l1.next, l2);
		} else {
			curNode.val = l2.val;
			curNode.next = mergeTwoLists(l1, l2.next);
		}

		return curNode;
	}

	// 2 迭代
	// 时间复杂度O(M + N)
	// 空间复杂度O(1)
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		// 创建哨兵节点
		ListNode preHead = new ListNode(-1);

		ListNode preNode = preHead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				preNode.next = l1;
				l1 = l1.next;
			} else {
				preNode.next = l2;
				l2 = l2.next;
			}

			preNode = preNode.next;
		}

		preNode.next = l1 == null ? l2 : l1;

		return preHead.next;
	}

// ====================测试代码=================
	public void test() {
		ListNode node14 = new ListNode(4);
		ListNode node12 = new ListNode(2, node14);
		ListNode node11 = new ListNode(1, node12);

		ListNode node24 = new ListNode(4);
		ListNode node23 = new ListNode(3, node24);
		ListNode node21 = new ListNode(1, node23);

		ListNode result = mergeTwoLists2(node11, node21);
		while (result != null) {
			System.out.print(result.val + "\t");
			result = result.next;
		}

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
