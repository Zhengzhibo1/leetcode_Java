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

// ===================算法实现====================
	// 方法 寻找插入点
	// 时间复杂度O(n^2)，其中n为链表的长度
	// 空间复杂度O(1)
	public ListNode insertionSortList(ListNode head) {

		// 边界条件判断
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode lastSorted = head;
		ListNode curNode = head.next;

		while (curNode != null) {
			// 进行排序
			if (curNode.val >= lastSorted.val) {
				lastSorted = lastSorted.next;
			} else {
				ListNode preNode = dummy;
				while (preNode.next.val <= curNode.val) {
					preNode = preNode.next;
				}
				lastSorted.next = curNode.next;
				curNode.next = preNode.next;
				preNode.next = curNode;
			}

			curNode = lastSorted.next;
		}

		return dummy.next;

	}

// ===================测试代码====================
	public void test1() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		node4.next = node2;
		node2.next = node1;
		node1.next = node3;

		ListNode result = insertionSortList(node4);
		while (result != null) {
			System.out.print(result.val + "\t");
			result = result.next;
		}

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();

	}

}
