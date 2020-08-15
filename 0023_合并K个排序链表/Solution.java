import java.util.Comparator;
import java.util.PriorityQueue;

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
	// 1 使用优先级队列合并 小顶堆
	// 时间复杂度O(KNlogk)，其中K为输入数组大小，N为所有链表中最长的链表长度
	// 其中采用优先级队列创建的小顶堆，插入与删除的时间复杂度均为O(logK)，其中最多有K个元素
	// 小顶堆的构建过程时间复杂度为O(logK)，每次插入或删除均会造成小顶堆的重新构建
	// 整个过程最多有KN个节点
	// 空间复杂度O(K)，采用小顶堆，其中最多有K个元素
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		// 哨兵节点
		ListNode res = new ListNode(-1);

		int length = lists.length;

		// 创建小顶堆
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(length, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}

		}); // 小顶堆，默认容量为length

		for (ListNode node : lists) {
			if (node != null) {
				minHeap.offer(node);
			}
		}
		ListNode temp = res;
		while (!minHeap.isEmpty()) {
			temp.next = minHeap.poll();
			temp = temp.next;
			if (temp.next != null) {
				minHeap.offer(temp.next);
			}
		}

		return res.next;
	}

	// 2 合并两链表 分治合并\
	// K为链表数组大小，N为最长链表长度
	// 时间复杂度O(KNlogK)，归并合并，迭代次数为logK
	// 第一轮合并K/2组链表，每一组的时间代价为O(2N)，
	// 第二轮合并K/4组链表，每一组的时间代价为O(4N)，
	// 总共迭代logK次
	// 空间复杂度O(1)
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		int length = lists.length;

		for (int step = 1; step < length; step *= 2) {
			for (int i = step; i < length; i += 2 * step) {
				lists[i - step] = mergeTwoLists(lists[i - step], lists[i]);
				lists[i] = null;
			}
		}

		return lists[0];
	}

	// 合并两链表
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		// 哨兵节点
		ListNode res = new ListNode(-1);
		ListNode temp = res;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				temp.next = list1;
				list1 = list1.next;
			} else {
				temp.next = list2;
				list2 = list2.next;
			}
			temp = temp.next;
		}

		if (list1 != null) {
			temp.next = list1;
		}

		if (list2 != null) {
			temp.next = list2;
		}

		return res.next;
	}

// ====================测试代码===================
	public void test() {
		ListNode node11 = new ListNode(1);
		ListNode node14 = new ListNode(4);
		ListNode node15 = new ListNode(5);

		node11.next = node14;
		node14.next = node15;

		ListNode node21 = new ListNode(1);
		ListNode node23 = new ListNode(3);
		ListNode node24 = new ListNode(4);

		node21.next = node23;
		node23.next = node24;

		ListNode node32 = new ListNode(2);
		ListNode node36 = new ListNode(6);

		node32.next = node36;

		ListNode[] lists = { node11, node21, node32 };
		ListNode result = mergeKLists2(lists);

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
