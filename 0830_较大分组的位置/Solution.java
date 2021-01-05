import java.util.ArrayList;
import java.util.List;

public class Solution {

// ===================算法实现=====================
	// 方法 一次遍历
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public List<List<Integer>> largeGroupPositions(String s) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		// 边界条件判断
		if (s == null || s.length() < 3) {
			return result;
		}

		int n = s.length();
		char temp = s.charAt(0);
		int count = 0;
		int start = 0;
		for (int i = 0; i < n; ++i) {
			if (s.charAt(i) == temp) {
				count++;
			} else {
				// 找到较大分组
				if (count >= 3) {
					List<Integer> tempList = new ArrayList<Integer>();
					tempList.add(start);
					tempList.add(start + count - 1);
					result.add(tempList);
				}

				temp = s.charAt(i);
				count = 1;
				start = i;
			}
		}

		// 最末尾的最大分组
		if (count >= 3) {
			List<Integer> tempList = new ArrayList<Integer>();
			tempList.add(start);
			tempList.add(start + count - 1);
			result.add(tempList);
		}

		return result;
	}

// ===================测试代码=====================
	public void test() {
		String s = "abcdddeeeeaabbbcd";
		List<List<Integer>> result = largeGroupPositions(s);
		for (List<Integer> ans : result) {
			for (int i : ans) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
