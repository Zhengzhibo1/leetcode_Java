public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ====================算法实现==================
	// 1 与下一个节点交换
	// 时间复杂度O(1)
	// 空间复杂度O(1)
	public void deleteNode(ListNode node) {

		node.val = node.next.val;
		node.next = node.next.next;

	}

// ====================测试代码==================
	ListNode node4 = new ListNode(4);
	ListNode node1 = new ListNode(1);
	ListNode node5 = new ListNode(5);
	ListNode node9 = new ListNode(9);

	public Solution() {

		node4.next = node1;
		node1.next = node5;
		node5.next = node9;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.deleteNode(s.node5);
		ListNode tempNode = s.node4;
		while (tempNode != null) {
			System.out.print(tempNode.val + "\t");
			tempNode = tempNode.next;
		}
	}

}
