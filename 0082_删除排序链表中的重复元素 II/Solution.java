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

// ====================算法实现======================
	// 方法 一次遍历
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public ListNode deleteDuplicates(ListNode head) {

		// 边界条件判断
		if (head == null || head.next == null) {
			return head;
		}

		// 哨兵节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode curNode = head;
		ListNode preNode = dummy;
		while (curNode != null) {
			int count = 0;
			ListNode tempNode = curNode;
			while (tempNode != null && tempNode.val == curNode.val) {
				count++;
				tempNode = tempNode.next;
			}

			if (count > 1) {
				preNode.next = tempNode;

			} else {
				preNode = curNode;
			}

			curNode = tempNode;
		}
		return dummy.next;
	}

// ====================测试代码======================
	public void test() {
		ListNode node7 = new ListNode(5, null);
		ListNode node6 = new ListNode(4, node7);
		ListNode node5 = new ListNode(4, node6);
		ListNode node4 = new ListNode(3, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		ListNode result = deleteDuplicates(node1);

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
