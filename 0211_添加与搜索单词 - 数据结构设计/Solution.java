public class WordDictionary {

	// 前缀树
	class TrieNode {
		private TrieNode[] links;
		private final int R = 27;
		private boolean isEnd;

		public TrieNode() {

			links = new TrieNode[R];
		}

		public boolean containsKey(char ch) {

			if (ch == '.') {
				return links[R - 1] != null;
			}
			return links[ch - 'a'] != null;
		}

		public TrieNode get(char ch) {

			if (ch == '.') {
				return links[R - 1];
			}
			return links[ch - 'a'];
		}

		public void put(char ch, TrieNode node) {
			if (ch == '.') {
				links[R - 1] = node;
			} else {
				links[ch - 'a'] = node;
			}
		}

		public void setEnd() {

			isEnd = true;
		}

		public boolean isEnd() {
			return isEnd;
		}
	}

// =================================================
	private TrieNode root;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	// 时间复杂度O(m)，m为字符串长度
	// 空间复杂度O(m)，最坏情况下，与当前Trie中无公共节点，此时需要添加m个节点
	public void addWord(String word) {
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

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	// 时间复杂度O(m)
	// 空间复杂度O(1)
	public boolean search(String word) {

		return searchWord(root, word);
	}

	private boolean searchWord(TrieNode root, String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); ++i) {
			char currentChar = word.charAt(i);
			if (node.containsKey(currentChar)) { // 匹配到当前字符
				node = node.get(currentChar);
			} else if (currentChar == '.') { // 如果未匹配到当前字符且当前字符为.
				for (int j = 'a'; j <= 'z'; ++j) { // 可以匹配a~z任何字符
					TrieNode tempNode = node.get((char) j);
					if (tempNode == null) { // 若为空，则表示该前缀树节点上不存在该字符，换下一个字符匹配
						if (j == 'z') { // 若z也为空，则字符.为多余，返回false
							return false;
						}
						continue;
					}
					if (searchWord(tempNode, word.substring(i + 1))) { // 字符.替代任一存在字符，接着往下匹配
						return true;
					}
				}
				// 若均匹配失败，则返回false
				return false;
			} else { // 字符不为.且匹配失败，则返回false
				return false;
			}
		}

		// 若匹配单词成功，最后一个节点位置的isEnd应该为true
		return node.isEnd;
	}

// ==================================================
	public static void main(String[] args) {
		WordDictionary w = new WordDictionary();

		w.addWord("at");
		w.addWord("and");
		w.addWord("an");
		w.addWord("add");
		w.addWord("bat");
		System.out.println(w.search(".at"));

	}

}
