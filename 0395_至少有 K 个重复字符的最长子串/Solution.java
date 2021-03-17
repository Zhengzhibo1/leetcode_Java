public class Solution {

// ===================算法实现========================
	// 方法 滑动窗口
	// 时间复杂度O(n)，因题意字符都为小写字母，最多26个，且每层遍历中，每个字符仅进入滑动窗口一次
	// 空间复杂度O(1)，创建固定数组充当计数器
	public int longestSubstring(String s, int k) {

		int result = 0;
		int n = s.length();
		for (int i = 1; i <= 26; ++i) { // 枚举26种字符种类的情况，取最大值
			// i 表示字符种类数
			int left = 0, right = 0;
			int[] cnt = new int[26];
			int tot = 0; // 实际字符种类数
			int less = 0; // 字符数量未达到k的字符计数器
			while (right < n) {
				cnt[s.charAt(right) - 'a']++; // 字符数量加1
				if (cnt[s.charAt(right) - 'a'] == 1) { // 如果该字符刚进入，字符种类与未达到k字符加1
					less++;
					tot++;
				}

				if (cnt[s.charAt(right) - 'a'] == k) { // 如果该字符数量达到k
					less--;
				}
				while (tot > i) { // 实际字符种类大于要求字符种类，left左移，减少实际字符种类
					cnt[s.charAt(left) - 'a']--;
					if (cnt[s.charAt(left) - 'a'] == k - 1) {
						less++;
					}

					if (cnt[s.charAt(left) - 'a'] == 0) {
						less--;
						tot--;
					}
					left++;
				}
				if (less == 0) {
					result = Math.max(result, right - left + 1);
				}
				right++;
			}
		}
		return result;
	}

// ===================测试代码========================
	public void test() {
		String s = "ababbc";
		int k = 2;
		int result = longestSubstring(s, k);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}
