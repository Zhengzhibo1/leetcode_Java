import java.util.LinkedList;
import java.util.Queue;

public class Codec {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ===================算法实现====================
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		// 采用宽度优先遍历序列化
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		// 存放序列化结果
		StringBuffer sb = new StringBuffer("[");

		while (!queue.isEmpty()) {
			// 取出队列第一个节点
			TreeNode tempNode = queue.poll();
			if (tempNode == null) {
				sb.append("null,");
			} else {
				sb.append(tempNode.val + ",");
				queue.add(tempNode.left);
				queue.add(tempNode.right);
			}
		}
		// 去掉最后一个“，”
		sb.setLength(sb.length() - 1);
		sb.append("]");
		return sb.toString();

	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		// substring不包括最后一个字符，即不包括结束位置
		String[] nodes = data.substring(1, data.length() - 1).split(",");
		// 如果第一个节点为空，则返回空
		if (nodes[0].equals("null")) {
			return null;
		}

		// 创建根节点
		TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
		// 存放父节点
		Queue<TreeNode> parents = new LinkedList<TreeNode>();
		parents.add(root);

		for (int i = 1; i < nodes.length; ++i) {
			TreeNode tempNode = parents.poll();
			if (!nodes[i].equals("null")) {
				tempNode.left = new TreeNode(Integer.parseInt(nodes[i]));
				parents.add(tempNode.left);
			}
			i++;
			if (!nodes[i].equals("null")) {
				tempNode.right = new TreeNode(Integer.parseInt(nodes[i]));
				parents.add(tempNode.right);
			}

		}

		return root;
	}

// ===================测试代码====================
//    1
//   / \
//  2   3
//     / \
//    4   5

	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;

		// 序列化二叉树
		TreeNode root = node1;
		String result = serialize(root);
		System.out.println("序列化结果：" + result);
		// 反序列化二叉树
		root = deserialize(result);
		preorder(root);
	}

	// 前序遍历二叉树
	public void preorder(TreeNode root) {
		System.out.println(root.val + "\t");
		if (root.left != null) {
			preorder(root.left);
		}

		if (root.right != null) {
			preorder(root.right);
		}
	}

	public static void main(String[] args) {
		Codec c = new Codec();
		c.test();

	}

}
