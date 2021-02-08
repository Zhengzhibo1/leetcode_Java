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

// ===================算法实现===================
	// 方法 一次遍历
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public ListNode reverseKGroup(ListNode head, int k) {

		// 哨兵节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode preNode = dummy;

		while (head != null) {
			ListNode tail = preNode;
			// 寻找k个节点的尾节点
			for (int i = 0; i < k; ++i) {
				tail = tail.next;
				if (tail == null) {
					// 如果长度不够k，返回结果
					return dummy.next;
				}
			}

			ListNode[] reverse = reverse(head, tail);
			head = reverse[0];
			tail = reverse[1];

			preNode.next = head;
			preNode = tail;
			head = tail.next;

		}

		return dummy.next;
	}

	private ListNode[] reverse(ListNode head, ListNode tail) {

		ListNode preNode = tail.next;
		ListNode pHead = head;
		while (preNode != tail) {
			ListNode headNext = pHead.next;
			pHead.next = preNode;
			preNode = pHead;
			pHead = headNext;
		}

		return new ListNode[] { tail, head };
	}

// ===================测试代码===================
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
