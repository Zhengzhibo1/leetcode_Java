import java.util.ArrayList;
import java.util.List;

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

// ====================算法实现=======================
	// 方法1 线性表
	// 时间复杂度O(n)，其中n为节点数
	// 空间复杂度O(n)，存放节点的数组
	public void reorderList(ListNode head) {

		// 边界条件判断
		if (head == null || head.next == null) {
			return;
		}

		// 存在节点数组
		List<ListNode> list = new ArrayList<ListNode>();
		ListNode tempNode = head;
		while (tempNode != null) {
			list.add(tempNode);
			tempNode = tempNode.next;
		}

		int size = list.size();
		int left = 0;
		int right = size - 1;
		while (left < right) {
			// 取出相应节点
			ListNode leftNode = list.get(left);
			ListNode rightNode = list.get(right);

			// 重新拼接
			leftNode.next = rightNode;
			rightNode.next = list.get(left + 1);

			left++;
			right--;
		}

		// 最后一个节点的下一个节点为空，防止链表成环
		list.get(left).next = null;
	}

	// 方法2 找到链表中点，反转链表后半部分，合并链表
	// 时间复杂度O(n)，n为节点数
	// 空间复杂度O(1)
	public void reorderList2(ListNode head) {

		// 边界条件判断
		if (head == null || head.next == null) {
			return;
		}

		ListNode middleNode = getMiddleNode(head);
		ListNode l1 = head;
		ListNode l2 = middleNode.next;
		// 断开成两条链表
		middleNode.next = null;
		// 翻转后半段链表
		l2 = reverseList(l2);
		// 合并链表
		mergeList(l1, l2);

	}

	// 寻找链表的中间节点
	private ListNode getMiddleNode(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	// 翻转链表
	private ListNode reverseList(ListNode head) {

		ListNode preNode = null;
		ListNode curNode = head;

		while (curNode != null) {
			ListNode nextNode = curNode.next;
			curNode.next = preNode;

			preNode = curNode;
			curNode = nextNode;
		}

		return preNode;
	}

	// 合并链表
	private void mergeList(ListNode l1, ListNode l2) {
		ListNode tempNode1 = null;
		ListNode tempNode2 = null;

		while (l1 != null && l2 != null) {
			tempNode1 = l1.next;
			tempNode2 = l2.next;

			l1.next = l2;
			l1 = tempNode1;

			l2.next = l1;
			l2 = tempNode2;
		}
	}

// ====================测试代码=======================
	public void test1() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		reorderList2(node1);

		ListNode tempNode = node1;
		while (tempNode != null) {
			System.out.print(tempNode.val + "\t");
			tempNode = tempNode.next;
		}

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();

	}

}
