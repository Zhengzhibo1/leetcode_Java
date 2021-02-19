import java.util.HashSet;
import java.util.Set;

public class Solution {

// ===================算法实现===================
	// 方法 哈希表
	// 时间复杂度O(m + n)，m位jewels的长度，n位stones的长度
	// 空间复杂度O(m)
	public int numJewelsInStones(String jewels, String stones) {

		Set<Character> set = new HashSet<Character>();
		int length1 = jewels.length();
		for (int i = 0; i < length1; ++i) {
			set.add(jewels.charAt(i));
		}
		int length2 = stones.length();
		int count = 0;
		for (int i = 0; i < length2; ++i) {
			if (set.contains(stones.charAt(i))) {
				count++;
			}
		}

		return count;
	}

// ===================测试代码===================
	public void test() {
		String J = "aA";
		String S = "aAAbbbb";
		int count = numJewelsInStones(J, S);
		System.out.println(count);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
