public class Solution {

// ====================算法实现=======================
	// 简单哈希表
	// ASCII字符，仅256，所以创建256大小的数组替代哈希表
	// 时间复杂度O(n)，其中n为字符串的长度
	// 空间复杂度O(1)，数组大小固定
	public int firstUniqChar(String s) {

		if (s == null || s.length() == 0) {
			return -1;
		}

		int index = -1;

		int hashTable[] = new int[256];
		for (int i = 0; i < s.length(); ++i) {
			hashTable[s.charAt(i)]++;
		}

		for (int i = 0; i < s.length(); ++i) {
			if (hashTable[s.charAt(i)] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}

// ====================测试代码=======================
	public void test() {
		String s = "leetcode";
		int result = firstUniqChar(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
