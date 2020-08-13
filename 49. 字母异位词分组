import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

// ====================算法实现==================
	// 1 排序数组分类
	// 时间复杂度O(NKlogK)，其中N是strs的长度，而K是strs中字符串的最大长度
	// 遍历每个字符的外部循环O(N)，然后，O(KlogK)的时间内对字符串排序
	// 空间复杂度O(NK)，字典存放临时结果
	public List<List<String>> groupAnagrams(String[] strs) {

		if (strs == null || strs.length == 0) {
			return new ArrayList<List<String>>();
		}

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String s : strs) {
			char[] str = s.toCharArray();
			Arrays.sort(str);
			String key = String.valueOf(str);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(s);
		}

		return new ArrayList<List<String>>(map.values());
	}

	// 2 按计数分类
	// 时间复杂度O(NK)
	// 空间复杂度O(NK)
	public List<List<String>> groupAnagrams2(String[] strs) {
		// 边界条件判断
		if (strs == null || strs.length == 0) {
			return new ArrayList<List<String>>();
		}

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		int[] count = new int[26];
		for (String s : strs) {
			Arrays.fill(count, 0);
			for (char c : s.toCharArray()) {
				count[c - 'a']++;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; ++i) {
				sb.append('#');
				sb.append(count[i]);
			}

			String key = sb.toString();
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(s);
		}

		return new ArrayList<List<String>>(map.values());
	}

// ====================测试代码==================
	public void test() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> results = groupAnagrams2(strs);

		for (List<String> result : results) {
			for (String s : result) {
				System.out.print(s + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
