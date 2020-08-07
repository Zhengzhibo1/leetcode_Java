public class Trie {

	// 前缀树
	class TrieNode {
		private TrieNode[] links;
		private final int R = 26;
		private boolean isEnd;

		public TrieNode() {

			links = new TrieNode[R];
		}

		public boolean containsKey(char ch) {

			return links[ch - 'a'] != null;
		}

		public TrieNode get(char ch) {

			return links[ch - 'a'];
		}

		public void put(char ch, TrieNode node) {
			links[ch - 'a'] = node;
		}

		public void setEnd() {

			isEnd = true;
		}

		public boolean isEnd() {
			return isEnd;
		}
	}

// ========================================================
	private TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	// 时间复杂度O(m)，m为字符串长度
	// 空间复杂度O(m)，最坏情况下，与当前Trie中无公共节点，此时需要添加m个节点
	public void insert(String word) {

		TrieNode node = root;
		for (int i = 0; i < word.length(); ++i) {
			char currentChar = word.charAt(i);
			if (!node.containsKey(currentChar)) {
				node.put(currentChar, new TrieNode());
			}
			node = node.get(currentChar);
		}
		node.setEnd();
	}

	/** Returns if the word is in the trie. */
	// 时间复杂度O(m)，m为字符串长度
	// 空间复杂度O(1)
	public boolean search(String word) {

		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	// 时间复杂度O(m)
	// 空间复杂度O(1)
	public boolean startsWith(String prefix) {

		TrieNode node = searchPrefix(prefix);
		return node != null;
	}

	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); ++i) {
			char currentChar = word.charAt(i);
			if (node.containsKey(currentChar)) {
				node = node.get(currentChar);
			} else {
				return null;
			}
		}

		return node;
	}

// ========================================================

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		boolean result1 = trie.search("apple"); // 返回 true
		System.out.println(result1);
		boolean result2 = trie.search("app"); // 返回 false
		System.out.println(result2);
		boolean result3 = trie.startsWith("app"); // 返回 true
		System.out.println(result3);
		trie.insert("app");
		boolean result4 = trie.search("app"); // 返回 true
		System.out.println(result4);

	}

}
