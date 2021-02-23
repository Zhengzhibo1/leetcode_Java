public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ===================算法实现======================
	// 方法 两次遍历，第一次遍历计算总节点数，第二次遍历找到相应节点
	// 时间复杂度O(n)，n为节点数
	// 空间复杂度O(1)
	public ListNode getKthFromEnd(ListNode head, int k) {

		// 计算总节点数
		int count = 0;
		ListNode tempNode = head;
		while (tempNode != null) {
			count++;
			tempNode = tempNode.next;
		}

		// 边界条件判断
		if (count < k) {
			return null;
		}

		// 目标节点索引
		int index = count - k + 1;
		tempNode = head;
		for (int i = 1; i < index; ++i) {
			tempNode = tempNode.next;
		}

		return tempNode;
	}

// ===================测试代码======================
	public void test() {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		int k = 2;
		ListNode result = getKthFromEnd(node1, k);
		System.out.println(result.val);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
