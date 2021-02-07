import java.util.ArrayList;
import java.util.List;

public class Solution {

// ===================算法实现====================
	// 方法 一次遍历
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public List<String> summaryRanges(int[] nums) {

		List<String> resultList = new ArrayList<String>();
		// 边界条件判断
		if (nums == null || nums.length == 0) {
			return resultList;
		}

		int start = 0;
		int end = 0;

		for (int i = 0; i < nums.length - 1; ++i) {

			if (nums[i + 1] != nums[i] + 1) {
				if (end == start) {
					resultList.add(String.valueOf(nums[i]));
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append(nums[start]);
					sb.append("->");
					sb.append(nums[end]);
					resultList.add(sb.toString());
				}

				start = end = i + 1;
			} else {
				end++;
			}
		}

		if (end == start) {
			resultList.add(String.valueOf(nums[start]));
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(nums[start]);
			sb.append("->");
			sb.append(nums[end]);
			resultList.add(sb.toString());
		}

		return resultList;
	}

// ===================测试代码====================
	public void test1() {
		int nums[] = { 0, 1, 2, 4, 5, 7 };
		List<String> resultList = summaryRanges(nums);
		for (String s : resultList) {
			System.out.print(s + "\t");
		}
	}

	public void test2() {

		int nums[] = { -2147483648, -2147483647, 2147483647 };
		List<String> resultList = summaryRanges(nums);
		for (String s : resultList) {
			System.out.print(s + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();

	}

}
