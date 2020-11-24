import java.util.HashMap;
import java.util.Map;

public class LRUCache {

// ======================算法实现====================
	// 方法：双向链表 + 哈希表
	// 双向链表
	class DLinkedNode {
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode next;

		public DLinkedNode() {

		}

		public DLinkedNode(int _key, int _value) {
			key = _key;
			value = _value;
		}
	}

	// 定义字典
	private Map<Integer, DLinkedNode> map = new HashMap<Integer, DLinkedNode>();
	private int size;
	private int capacity;
	private DLinkedNode head, tail;

	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		head = new DLinkedNode();
		tail = new DLinkedNode();
		head.next = tail;
		tail.pre = head;

	}

	public int get(int key) {

		// 从map中判断节点是否存在
		DLinkedNode node = map.get(key);
		if (node == null) {
			// 如果map中不存在该节点
			return -1;
		}
		// map中存在该节点
		// 将该节点移动到链表头部，并返回值
		moveToHead(node);
		return node.value;
	}

	public void put(int key, int value) {

		// 首先从map中判断该节点是否存在
		DLinkedNode node = map.get(key);
		if (node == null) {
			// 如果该节点不存在，则创建一个新的节点
			DLinkedNode newNode = new DLinkedNode(key, value);
			// 添加到链表的头部
			addToNode(newNode);
			// 存入map中
			map.put(key, newNode);
			// 大小加1
			size++;
			// 如果超过容量
			if (size > capacity) {
				// 删除尾节点
				DLinkedNode tailNode = removeTail();
				// 从map中删除相应的值
				map.remove(tailNode.key);
			}
		} else {
			// 如果该节点存在，则更新该节点的值
			node.value = value;
			// 移动节点到链表头部
			moveToHead(node);
		}
	}

	// 在双向链表头部添加节点
	private void addToNode(DLinkedNode node) {
		node.pre = head;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
	}

	// 双向链表中移除节点
	private void removeNode(DLinkedNode node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	// 移动节点到双向链表的头部
	private void moveToHead(DLinkedNode node) {
		removeNode(node);
		addToNode(node);
	}

	// 删除双向链表的尾节点
	private DLinkedNode removeTail() {
		DLinkedNode tailNode = tail.pre;
		removeNode(tailNode);
		return tailNode;
	}

// ====================测试代码========================
	public static void main(String[] args) {
		LRUCache l = new LRUCache(2);
		l.put(1, 1);
		l.put(2, 2);
		System.out.println(l.get(1));
		l.put(3, 3);
		System.out.println(l.get(2));
		l.put(4, 4);
		System.out.println(l.get(1));
		System.out.println(l.get(3));
		System.out.println(l.get(4));

	}

}
