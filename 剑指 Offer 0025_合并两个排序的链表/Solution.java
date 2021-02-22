public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ===================算法实现======================
	// 方法 一次遍历
	// 时间复杂度O(m + n), m和n分别为两链表的长度，每个节点遍历一次
	// 空间复杂度O(1)
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		// 哨兵节点
		ListNode dummy = new ListNode(-1);
		ListNode curNode1 = l1;
		ListNode curNode2 = l2;
		ListNode curNode = dummy;
		while (curNode1 != null && curNode2 != null) {

			if (curNode1.val < curNode2.val) {
				curNode.next = curNode1;
				curNode1 = curNode1.next;
				curNode = curNode.next;
			} else {
				curNode.next = curNode2;
				curNode2 = curNode2.next;
				curNode = curNode.next;
			}
		}

		if (curNode1 != null) {
			curNode.next = curNode1;
		}

		if (curNode2 != null) {
			curNode.next = curNode2;
		}

		return dummy.next;
	}

// ===================测试代码======================
	public void test() {
		ListNode nodeA4 = new ListNode(4);
		ListNode nodeA2 = new ListNode(2);
		ListNode nodeA1 = new ListNode(1);

		nodeA1.next = nodeA2;
		nodeA2.next = nodeA4;

		ListNode nodeB1 = new ListNode(1);
		ListNode nodeB3 = new ListNode(3);
		ListNode nodeB4 = new ListNode(4);
		nodeB1.next = nodeB3;
		nodeB3.next = nodeB4;

		ListNode root = mergeTwoLists(nodeA1, nodeB1);
		while (root != null) {
			System.out.print(root.val + "\t");
			root = root.next;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
