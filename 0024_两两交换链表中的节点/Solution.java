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

// ====================算法实现=====================
	// 方法1 迭代
	// 时间复杂度O(n)，n为数组的长度
	// 空间复杂度O(1)
	public ListNode swapPairs(ListNode head) {

		// 边界条件判断
		if (head == null || head.next == null) {
			return head;
		}

		// 哨兵节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode curNode = dummy;
		ListNode node1 = null;
		ListNode node2 = null;
		ListNode nextNode = null;
		while (curNode.next != null && curNode.next.next != null) {
			node1 = curNode.next;
			node2 = node1.next;
			nextNode = node2.next;

			curNode.next = node2;
			node2.next = node1;
			node1.next = nextNode;

			curNode = node1;

		}

		return dummy.next;
	}

	// 方法2 递归
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public ListNode swapPairs2(ListNode head) {

		// 边界条件判断
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = head.next;
		head.next = swapPairs2(newHead.next);
		newHead.next = head;
		return newHead;
	}

// ====================测试代码=====================
	public void test() {
		ListNode node4 = new ListNode(4, null);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		ListNode newHead = swapPairs2(node1);
		while (newHead != null) {
			System.out.print(newHead.val + "\t");
			newHead = newHead.next;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}
