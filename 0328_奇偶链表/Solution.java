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

// ====================算法实现===================
	// 1 拆成两条链表，最后再合并
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public ListNode oddEvenList(ListNode head) {

		// 创建哨兵节点
		ListNode preOdd = new ListNode(-1);
		ListNode preEven = new ListNode(-1);

		ListNode curNode = head;
		ListNode oddTemp = preOdd;
		ListNode evenTemp = preEven;
		while (curNode != null) {
			evenTemp.next = curNode;
			evenTemp = evenTemp.next;
			curNode = curNode.next;
			if (curNode != null) {
				oddTemp.next = curNode;
				oddTemp = oddTemp.next;
				curNode = curNode.next;
			}
		}

		oddTemp.next = null;
		evenTemp.next = preOdd.next;
		return preEven.next;
	}

// ===================测试代码===================
	public void test() {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		ListNode tempNode = oddEvenList(node1);
		;
		while (tempNode != null) {
			System.out.print(tempNode.val + "\t");
			tempNode = tempNode.next;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
