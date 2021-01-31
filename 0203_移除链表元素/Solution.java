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

// ===================算法实现==================
	// 方法 一次遍历
	// 时间复杂度O(n)，n为节点数
	// 空间复杂度O(1)
	public ListNode removeElements(ListNode head, int val) {

		// 哨兵节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		// 用curNode节点记住前节点
		ListNode curNode = dummy;

		while (curNode != null && curNode.next != null) {
			if (curNode.next.val == val) {
				curNode.next = curNode.next.next;
			} else {
				curNode = curNode.next;
			}
		}

		return dummy.next;
	}

// ===================测试代码==================
	public void test() {
		ListNode node6 = new ListNode(6, null);
		ListNode node5 = new ListNode(5, node6);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode nodex = new ListNode(6, node3);
		ListNode node2 = new ListNode(2, nodex);
		ListNode node1 = new ListNode(1, node2);

		ListNode result = removeElements(node1, 6);
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
