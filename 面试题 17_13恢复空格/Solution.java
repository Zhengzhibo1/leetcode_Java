import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

// ====================算法实现====================
	// 总结：
	// 1、 时间复杂度O(|dictionary| + n^2)，其中|dictionary|代表词典中的总字符数
	// n为sentence的字符数量，遍历sentence的时候，对于每个字符都需要往前遍历需要dp。
	// 因此时间复杂度为O(n^2)
	// 1、空间复杂度O(|dictionary| * S + n)，其中S代表字符集大小，因为这里都是小写字母，所以S = 26
	// 对于每个节点都开辟了S大小的空间，故空间复杂度为O(|dictionary| * S),节点数小于字典总字符数
	// dp数组的空间复杂度为O(n)

	// 2、时间复杂度，同1
	// 2、空间复杂度，由于仅需存每个单词的哈希值，所以空间复杂度为O(n + q)，其中n为sentence字符数，
	// q为词典单词个数，每个单词存一个哈希值，通过比较哈希值，来判断是否匹配到相应的单词。

	// 由于方法2将一个单词存为一个哈希值，所以不能像方法1那样通过逐步判断字符，根据词缀提前结束错误的匹配
	// 所以在测试集的运行时间上，方法1明显由于方法2

	// 1、字典树Trie+动态规划
	public int respace(String[] dictionary, String sentence) {
		int n = sentence.length();

		// 创建字典树，并将字典中的单词插入字典树中
		Trie root = new Trie();
		for (String word : dictionary) {
			root.insert(word);
		}

		// 创建数组保存结果，例dp[1]指的是考虑前1个字符最少的未识别的字符数量
		// 因为后面要进行比较，故都设置为Int型的最大值
		int[] dp = new int[n + 1];
		Arrays.fill(dp, n);
		dp[0] = 0;

		for (int i = 1; i <= n; ++i) {
			dp[i] = dp[i - 1] + 1;
			Trie curPos = root;

			for (int j = i; j >= 1; --j) {
				int t = sentence.charAt(j - 1) - 'a';
				if (curPos.next[t] == null) {
					break;
				} else if (curPos.next[t].isEnd) {
					dp[i] = Math.min(dp[i], dp[j - 1]);
				}

				if (dp[i] == 0) {
					break;
				}

				curPos = curPos.next[t];
			}
		}

		return dp[n];
	}

	class Trie {
		public Trie[] next;
		public boolean isEnd;

		public Trie() {
			next = new Trie[26];
			isEnd = false;
		}

		public void insert(String s) {
			Trie curPos = this;
			for (int i = s.length() - 1; i >= 0; --i) {
				int t = s.charAt(i) - 'a';
				if (curPos.next[t] == null) {
					curPos.next[t] = new Trie();
				}
				curPos = curPos.next[t];
			}
			curPos.isEnd = true;
		}
	}

	// 2、字符串哈希
	static final long P = Integer.MAX_VALUE;
	static final long BASE = 41;

	public int respace2(String[] dictionary, String sentence) {

		Set<Long> hashValues = new HashSet<Long>();
		for (String word : dictionary) {
			hashValues.add(getHash(word));
		}

		int[] f = new int[sentence.length() + 1];
		Arrays.fill(f, sentence.length());
		f[0] = 0;

		for (int i = 1; i <= sentence.length(); ++i) {
			f[i] = f[i - 1] + 1;
			long hashValue = 0;
			for (int j = i; j >= 1; --j) {
				int t = sentence.charAt(j - 1) - 'a' + 1;
				hashValue = (hashValue * BASE + t) % P;
				if (hashValues.contains(hashValue)) {
					f[i] = Math.min(f[i], f[j - 1]);
				}

				// 添加判断，如果未识别字符数量为0，已经到达最低，跳出循环
				// 测试结果表明节省了一部分时间
				if (f[i] == 0) {
					break;
				}
			}
		}

		return f[sentence.length()];
	}

	public long getHash(String s) {
		long hashValue = 0;
		for (int i = s.length() - 1; i >= 0; --i) {
			hashValue = (hashValue * BASE + s.charAt(i) - 'a' + 1) % P;
		}
		return hashValue;
	}

// ====================测试代码====================
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] dictionary = { "looked", "just", "like", "her", "brother" };
		String sentence = "jesslookedjustliketimherbrother";
		int result = s.respace2(dictionary, sentence);
		System.out.println(result);
	}

}
