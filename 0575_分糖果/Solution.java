import java.util.HashSet;
import java.util.Set;

public class Solution {

// ===================算法实现======================
	// 方法 哈希表
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int distributeCandies(int[] candyType) {

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < candyType.length; ++i) {
			set.add(candyType[i]);
		}

		int middle = candyType.length / 2;

		return middle > set.size() ? set.size() : middle;
	}

// ===================测试代码======================
	public void test() {
		int[] candyType = { 6, 6, 6, 6 };
		int result = distributeCandies(candyType);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
