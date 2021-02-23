public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ===================算法实现=====================
	// 方法1 迭代
	// 时间复杂度O(n)，n为链表节点数
	// 空间复杂度O(1)
	public ListNode deleteNode(ListNode head, int val) {

		// 哨兵节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode preNode = dummy;
		ListNode curNode = head;

		while (curNode != null) {

			if (curNode.val == val) {
				// 如果当前节点为要删除的节点
				preNode.next = curNode.next;
				curNode.next = null;
				break;
			}

			preNode = curNode;
			curNode = curNode.next;
		}

		return dummy.next;
	}

	// 方法2 递归
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public ListNode deleteNode2(ListNode head, int val) {

		// 边界条件判断
		if (head == null) {
			return head;
		}

		if (head.val == val) {
			return head.next;
		}

		head.next = deleteNode2(head.next, val);

		return head;
	}

// ===================测试代码=====================
	public void test() {
		ListNode node1 = new ListNode(1);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node9 = new ListNode(9);

		node4.next = node5;
		node5.next = node1;
		node1.next = node9;

		int val = 5;
		ListNode result = deleteNode2(node4, val);
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
